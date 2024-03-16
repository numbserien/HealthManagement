package com.zq.demo.service.impl;

import com.zq.demo.service.impl.user.RolesPermissionsServiceImpl;
import com.zq.demo.service.impl.user.UserRolesServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class UserRolesServiceImplTest {
    @Resource
    UserRolesServiceImpl userRolesService;
    @Resource
    RolesPermissionsServiceImpl rolesPermissionsService;

    @Test
    void getRolesIdListByUserId() {
        //用户的角色列表
        List<String> roles = userRolesService.getRolesListByUserId(2L);
        List<Long> roleIds = userRolesService.getRolesIdListByUserId(2L);
        //根据角色列表加载用户权限
        List<String> authorities = rolesPermissionsService.getPermissionListByRoleList(roleIds);
        System.out.println(authorities);
        //角色是一种特殊的权限
        roles = roles.stream().map(rc -> "ROLE_" + rc).collect(Collectors.toList());
        authorities.addAll(roles);
        System.out.println(roleIds);
        System.out.println(AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", authorities)));
    }

    @Test
    void getRolesListByUserId() {
    }
}