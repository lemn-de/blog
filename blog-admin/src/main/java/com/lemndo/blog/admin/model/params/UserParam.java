package com.lemndo.blog.admin.model.params;

import lombok.Data;

@Data
public class UserParam {

    private Long id;

    private String nickname;

    private String avatar;

    /**
     * 账号
     */
    private String account;

    /**
     * 是否管理员
     */
    private Integer admin;

    /**
     * 密码
     */
    private String password;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 状态
     */
    private String status;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobilePhoneNumber;

    /**
     * 分页
     */
    private Integer currentPage;

    private Integer pageSize;

    /**
     * 查询条件
     */
    private String queryString;
}