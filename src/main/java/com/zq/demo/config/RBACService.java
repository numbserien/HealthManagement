package com.zq.demo.config;


import com.zq.demo.filter.UsernamePasswordAuthentication.UserDetailServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@Component("rbacService")
public class RBACService {
    @Resource
    private UserDetailServiceImpl userDetailService;

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof String) {
            UserDetails userDetails = userDetailService.loadUserByUsername((String) principal);
            if (userDetails == null) {
                return false;
            }
            // 本次要访问的资源
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(request.getRequestURI());
            // 处理 * 的访问情况
            for (GrantedAuthority item:userDetails.getAuthorities()){
                String url = item.getAuthority();
                if (url.endsWith("*")){
                    String realUrl = url.substring(0, url.length() - 2);
                    return simpleGrantedAuthority.getAuthority().startsWith(realUrl);
                }
            }
            return userDetails.getAuthorities().contains(simpleGrantedAuthority);
        }
        return false;
    }
}
