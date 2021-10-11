package com.lemndo.blog.admin.service;

import com.lemndo.blog.admin.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lemndo.blog.admin.model.params.UserParam;
import com.lemndo.blog.admin.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lemndo
 * @since 2021-10-11
 */
public interface ISysUserService extends IService<SysUser> {

    Result listUser(UserParam userParam);

    Result deleteUser(Long id);

    Result updateUser(SysUser sysUser);
}
