package com.lemndo.blog.admin.controller;


import com.lemndo.blog.admin.entity.Permission;
import com.lemndo.blog.admin.model.params.PageParam;
import com.lemndo.blog.admin.service.IArticleService;
import com.lemndo.blog.admin.service.IPermissionService;
import com.lemndo.blog.admin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
    @Autowired
    private IArticleService articleService;

    @PostMapping("permission/permissionList")
    public Result listPermission(@RequestBody PageParam pageParam){

        return permissionService.listPermission(pageParam);
    }

    @PostMapping("permission/add")
    public Result add(@RequestBody Permission permission){
        return permissionService.addPerssion(permission);
    }

    @PostMapping("permission/update")
    public Result update(@RequestBody Permission permission){
        return permissionService.updatePerssion(permission);
    }

    @GetMapping("permission/delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        return permissionService.deletePerssion(id);
    }

    @PostMapping("article/articleList")
    public Result listArtilce(@RequestBody PageParam pageParam) {
        return articleService.listArtilce(pageParam);
    }
}
