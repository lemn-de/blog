package com.lemndo.blog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lemndo.blog.admin.entity.Permission;
import com.lemndo.blog.admin.entity.SysUser;
import com.lemndo.blog.admin.mapper.SysUserMapper;
import com.lemndo.blog.admin.model.params.UserParam;
import com.lemndo.blog.admin.service.ISysUserService;
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
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public Result listUser(UserParam userParam) {
        Page<SysUser> page = new Page<>(userParam.getCurrentPage(), userParam.getPageSize());
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(userParam.getQueryString())) {
            queryWrapper.and(wrapper -> wrapper.like(SysUser::getAccount, "%" + userParam.getQueryString()+"%"))
                    .or()
                    .like(SysUser::getNickname,"%" + userParam.getQueryString()+"%");
        }
        Page<SysUser> userPage= userMapper.selectPage(page, queryWrapper);
        PageResult<SysUser> pageResult = new PageResult<>();
        pageResult.setList(userPage.getRecords());
        pageResult.setTotal(userPage.getTotal());
        return Result.success(pageResult);
    }

    @Override
    public Result deleteUser(Long id) {
        this.userMapper.deleteById(id);
        return Result.success(id);
    }
}
