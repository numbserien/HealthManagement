package com.zq.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zq.demo.pojo.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author GL
 * @since 2024-01-31
 */
public interface IUserService extends IService<User> {

    String getUserAuthorityInfo(Integer userId);
}
