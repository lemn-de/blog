package com.lemndo.blog.service;

import com.lemndo.blog.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lemndo.blog.vo.ArticleBodyVo;
import com.lemndo.blog.vo.Result;
import com.lemndo.blog.vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lemndo
 * @since 2021-10-09
 */
public interface ISysUserService extends IService<SysUser> {

    UserVo findUserVoById(Long id);

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    /**
     * 根据token查询用户信息
     * @param token
     * @return
     */
    Result findUserByToken(String token);

    SysUser findUserByAccount(String account);

}
