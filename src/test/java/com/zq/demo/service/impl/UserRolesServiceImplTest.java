package com.zq.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zq.demo.dao.RolesDao;
import com.zq.demo.dao.UserDao;
import com.zq.demo.dao.UserRolesDao;
import com.zq.demo.pojo.UserRoles;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserRolesServiceImplTest {
    @Resource
    private UserRolesDao userRolesDao;

    @Resource
    private UserDao userDao;
    @Resource
    private RolesDao rolesDao;

    @Test
    void getRolesIdListByUserId() {
        LambdaQueryWrapper<UserRoles> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(UserRoles::getRoleId)
                .eq(UserRoles::getUserId, 2);
        System.out.println(this.userRolesDao.selectObjs(queryWrapper));
    }

    @Test
    void getRolesListByUserId() {
    }
}