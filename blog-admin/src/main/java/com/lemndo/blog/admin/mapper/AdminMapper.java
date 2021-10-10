package com.lemndo.blog.admin.mapper;

import com.lemndo.blog.admin.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemndo.blog.admin.entity.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lemndo
 * @since 2021-10-10
 */
@Repository
public interface AdminMapper extends BaseMapper<Admin> {

    @Select("SELECT * FROM ms_permission WHERE id IN (SELECT permission_id FROM ms_admin_permission WHERE admin_id=#{adminId})")
    List<Permission> findPermissionByAdminId(Long adminId);
}
