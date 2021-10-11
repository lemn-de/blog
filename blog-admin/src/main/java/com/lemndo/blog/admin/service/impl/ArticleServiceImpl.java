package com.lemndo.blog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemndo.blog.admin.entity.Article;
import com.lemndo.blog.admin.entity.Permission;
import com.lemndo.blog.admin.mapper.ArticleMapper;
import com.lemndo.blog.admin.model.params.ArticleParam;
import com.lemndo.blog.admin.model.params.PageParam;
import com.lemndo.blog.admin.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lemndo.blog.admin.vo.PageResult;
import com.lemndo.blog.admin.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lemndo
 * @since 2021-10-11
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result listArtilce(ArticleParam articleParam) {
        Page<Article> page = new Page<>(articleParam.getCurrentPage(), articleParam.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(articleParam.getQueryString())) {
            queryWrapper.like(Article::getTitle, "%"+articleParam.getQueryString()+"%");
        }
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        PageResult<Article> pageResult = new PageResult<>();
        pageResult.setList(articlePage.getRecords());
        pageResult.setTotal(articlePage.getTotal());
        return Result.success(pageResult);
    }

    @Override
    public Result deleteArticle(Long id) {
        this.articleMapper.deleteById(id);
        return Result.success(id);
    }
}
