package com.lemndo.blog.admin.service;

import com.lemndo.blog.admin.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lemndo.blog.admin.model.params.PageParam;
import com.lemndo.blog.admin.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lemndo
 * @since 2021-10-11
 */
public interface IArticleService extends IService<Article> {

    Result listArtilce(PageParam pageParam);
}
