package com.zq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zq.demo.dao.UserDao;
import com.zq.demo.pojo.User;
import com.zq.demo.service.IUserService;
import org.springframework.stereotype.Service;

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

    //    TODO 根据用户名返回用户信息(id,username,password)
    public User getByUsername(String username) {
        return null;
    }

}
