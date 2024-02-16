package com.zq.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zq.demo.dao.UserDao;
import com.zq.demo.pojo.User;
import com.zq.demo.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author GL
 * @since 2024-02-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

    @Resource
    private UserDao userDao;

    //    根据用户名返回用户信息(id,username,password,status)
    public User getByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(username != null, User::getUsername, username)
                .select(User::getId, User::getUsername, User::getPassword, User::getStatus);
        return userDao.selectOne(queryWrapper);
    }

}
