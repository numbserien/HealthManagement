package com.zq.demo.filter.UsernamePasswordAuthentication;

import com.zq.demo.pojo.user.User;
import com.zq.demo.service.impl.user.RolesPermissionsServiceImpl;
import com.zq.demo.service.impl.user.UserRolesServiceImpl;
import com.zq.demo.service.impl.user.UserServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    UserServiceImpl sysUserService;
    @Resource
    UserRolesServiceImpl userRolesService;
    @Resource
    RolesPermissionsServiceImpl rolesPermissionsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //用户基础数据加载
        User sysUser = sysUserService.getByUsernameToAuth(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return new AccountUser(
                ""+sysUser.getId(), sysUser.getPassword(), sysUser.getStatus().equals("1"), getUserAuthority(sysUser.getId()));
    }

    /**
     * 获取用户权限信息（角色、菜单权限）
     */
    public List<GrantedAuthority> getUserAuthority(Integer userId) {
        // 角色(比如ROLE_admin)，菜单操作权限(比如sys:user:list)
        // 比如ROLE_admin,ROLE_normal,sys:user:list,...

        //用户的角色列表
        List<String> roles = userRolesService.getRolesListByUserId(userId);
        List<Long> roleIds = userRolesService.getRolesIdListByUserId(userId);
        //根据角色列表加载用户权限
        List<String> authorities = rolesPermissionsService.getPermissionListByRoleList(roleIds);
        //角色是一种特殊的权限
        roles = roles.stream().map(rc -> "ROLE_" + rc).collect(Collectors.toList());
        authorities.addAll(roles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", authorities));
    }
}
