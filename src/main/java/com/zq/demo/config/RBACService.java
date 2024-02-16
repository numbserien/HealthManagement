package com.zq.demo.config;


import com.zq.demo.filter.UsernamePasswordAuthentication.UserDetailServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
            return userDetails.getAuthorities().contains(simpleGrantedAuthority);
        }
        return false;
    }
}
