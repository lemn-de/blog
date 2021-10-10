package com.lemndo.blog.admin.service;

import com.lemndo.blog.admin.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lemndo.blog.admin.entity.Permission;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lemndo
 * @since 2021-10-10
 */
public interface IAdminService extends IService<Admin> {

    Admin findAdminByUserName(String username);

    List<Permission> findPermissionByAdminId(Long adminId);
}
