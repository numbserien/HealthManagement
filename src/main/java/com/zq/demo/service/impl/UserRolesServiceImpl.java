package com.zq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zq.demo.dao.UserRolesDao;
import com.zq.demo.pojo.UserRoles;
import com.zq.demo.service.IUserRolesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author GL
 * @since 2024-02-09
 */
@Service
public class UserRolesServiceImpl extends ServiceImpl<UserRolesDao, UserRoles> implements IUserRolesService {
    //    TODO 根据userid查出角色
    public List<String> getRolesListByUserId(Long userId) {
        return new ArrayList<>();
    }
}
