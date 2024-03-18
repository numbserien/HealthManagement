package com.zq.demo.filter.UsernamePasswordAuthentication;

import cn.hutool.core.lang.Assert;
import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.zq.demo.pojo.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AccountUser implements UserDetails {

    private static final long serialVersionUID = 540L;
    private static final Log logger = LogFactory.getLog(User.class);
    private final String username;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean accountNonExpired;  // 是否没过期
    private final boolean accountNonLocked;   // 是否没被锁定
    private final boolean credentialsNonExpired; //
    private final String password;
    private final boolean enabled;


    public AccountUser(String username, String password, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        this(username, password, enabled, true, true, true, authorities);
    }

    public AccountUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        Assert.isTrue(username != null && !username.isEmpty() && password != null, "Cannot pass null or empty values to constructor");
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authorities = authorities;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
