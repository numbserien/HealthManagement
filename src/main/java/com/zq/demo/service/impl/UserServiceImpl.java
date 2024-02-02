package com.zq.demo.service.impl;

import com.zq.demo.pojo.User;
import com.zq.demo.dao.UserDao;
import com.zq.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GL
 * @since 2024-01-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

}
