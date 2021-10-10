package com.lemndo.blog.admin.controller;


import com.lemndo.blog.admin.model.params.PageParam;
import com.lemndo.blog.admin.service.IPermissionService;
import com.lemndo.blog.admin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lemndo
 * @since 2021-10-10
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IPermissionService permissionService;

    @PostMapping("permission/permissionList")
    public Result listPermission(@RequestBody PageParam pageParam){

        return permissionService.listPermission(pageParam);
    }
}
