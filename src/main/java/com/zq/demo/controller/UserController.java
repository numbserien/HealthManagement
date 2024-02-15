package com.zq.demo.controller;


import com.zq.demo.filter.Sequrity.PasswordEncoder;
import com.zq.demo.pojo.User;
import com.zq.demo.pojo.sys.Result;
import com.zq.demo.service.impl.UserServiceImpl;
import com.zq.demo.util.Const;
import com.zq.demo.util.RSAUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author GL
 * @since 2024-02-09
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserServiceImpl userService;
    @Resource
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Result register(@RequestBody User sysUser) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            //查询当前账号是否存在
            User sysUser1 = userService.getByUsername(sysUser.getName());
            if (sysUser1 != null) {
                return Result.failure("当前账号已经存在，请更换账号");
            }
            //RSA解密
            String pwd = RSAUtils.decryptByPrivate(sysUser.getPassword(), Const.RsaPrivateKey);
            //SpringSecurity 密码编码
            String encodePwd = passwordEncoder.encode(pwd);
            sysUser.setPassword(encodePwd);
            userService.save(sysUser);
            return Result.success("注册成功！");

        } finally {
            lock.unlock();
        }

    }
}

