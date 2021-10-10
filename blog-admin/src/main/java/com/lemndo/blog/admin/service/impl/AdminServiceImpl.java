package com.lemndo.blog.admin.service.impl;

import com.lemndo.blog.admin.entity.Admin;
import com.lemndo.blog.admin.mapper.AdminMapper;
import com.lemndo.blog.admin.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lemndo
 * @since 2021-10-10
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
