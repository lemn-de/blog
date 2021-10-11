package com.lemndo.blog.admin.controller;


import com.lemndo.blog.admin.entity.Permission;
import com.lemndo.blog.admin.entity.SysUser;
import com.lemndo.blog.admin.model.params.ArticleParam;
import com.lemndo.blog.admin.model.params.PageParam;
import com.lemndo.blog.admin.model.params.UserParam;
import com.lemndo.blog.admin.service.IArticleService;
import com.lemndo.blog.admin.service.IPermissionService;
import com.lemndo.blog.admin.service.ISysUserService;
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
    @Autowired
    private ISysUserService userService;

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
    public Result listArtilce(@RequestBody ArticleParam articleParam) {
        return articleService.listArtilce(articleParam);
    }

    @GetMapping("article/delete/{id}")
    public Result deleteArticle(@PathVariable("id") Long id){
        return articleService.deleteArticle(id);
    }

    @PostMapping("user/userList")
    public Result listUser(@RequestBody UserParam userParam){
        return userService.listUser(userParam);
    }

    @PostMapping("user/update")
    public Result updateUser(@RequestBody SysUser sysUser){
        return userService.updateUser(sysUser);
    }

    @GetMapping("user/delete/{id}")
    public Result deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }
}
