package com.zq.demo.filter.jwt;

import com.zq.demo.pojo.User;
import com.zq.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserServiceImpl sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User sysUser = sysUserService.getByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }


        return new AccountUser(sysUser.getU_id(), sysUser.getU_name(), sysUser.getU_password(), getUserAuthority(sysUser.getU_id()));

    }

    /**
     * 获取用户权限信息（角色、菜单权限）
     *
     * @param userId
     * @return
     */
    public List<GrantedAuthority> getUserAuthority(Integer userId) {
        // 角色(比如ROLE_admin)，菜单操作权限(比如sys:user:list)
        String authority = sysUserService.getUserAuthorityInfo(userId);     // 比如ROLE_admin,ROLE_normal,sys:user:list,...

        return AuthorityUtils.commaSeparatedStringToAuthorityList(authority);
    }
}
