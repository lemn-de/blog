package com.lemndo.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.lemndo.blog.entity.SysUser;
import com.lemndo.blog.service.ISysUserService;
import com.lemndo.blog.service.LoginService;
import com.lemndo.blog.utils.JWTUtils;
import com.lemndo.blog.vo.ErrorCode;
import com.lemndo.blog.vo.Result;
import com.lemndo.blog.vo.params.LoginParam;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String slat = "lemndo@mzb";

    /**
     * 1.检查参数是否合法
     * 2.根据用户名和密码去user表中查询 是否存在
     * 3.如果不存在 登陆失败
     * 4.如果存在 使用jwt生成token返回给前端
     * 5.token放入redis中， redis  token：user信息 设置过期时间
     * （登录认证的时候，先认证token字符串是否合法，去redis认证是否存在）
     * @param loginParam
     * @return
     */
    @Override
    public Result login(LoginParam loginParam) {
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(),ErrorCode.PARAMS_ERROR.getMsg());
        }
        password = DigestUtils.md5Hex(password + slat);
        System.out.println("前端密码:" + password);
        SysUser sysUser = sysUserService.findUser(account, password);
        if (sysUser == null) {
            return Result.fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        String token = JWTUtils.createToken(sysUser.getId());
        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(sysUser), 1, TimeUnit.DAYS);
        return Result.success(token);
    }
}
