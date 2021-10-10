package com.lemndo.blog.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private IAdminService adminService;

    public boolean auth(HttpServletRequest request, Authentication authentication) {
        //权限认证
        String requestURI = request.getRequestURI();
        Object principal = authentication.getPrincipal();

        return true;
    }
}
