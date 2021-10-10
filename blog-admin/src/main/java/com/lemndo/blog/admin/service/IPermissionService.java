package com.lemndo.blog.admin.service;

import com.lemndo.blog.admin.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lemndo.blog.admin.model.params.PageParam;
import com.lemndo.blog.admin.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lemndo
 * @since 2021-10-10
 */
public interface IPermissionService extends IService<Permission> {

    /**
     * 数据为表的所有字段
     * 分页查询
     * @param pageParam
     * @return
     */
    Result listPermission(PageParam pageParam);

    Result addPerssion(Permission permission);

    Result updatePerssion(Permission permission);

    Result deletePerssion(Long id);
}
