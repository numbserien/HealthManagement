package com.zq.demo.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zq.demo.dao.user.RolesDao;
import com.zq.demo.dao.user.UserRolesDao;
import com.zq.demo.pojo.user.Roles;
import com.zq.demo.pojo.user.UserRoles;
import com.zq.demo.service.interfaces.user.IUserRolesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Resource
    private UserRolesDao userRolesDao;

    @Resource
    private RolesDao rolesDao;

    // 根据userId查出roleId
    public List<Long> getRolesIdListByUserId(Integer userId) {
        LambdaQueryWrapper<UserRoles> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(UserRoles::getRoleId)
                .eq(userId != null, UserRoles::getUserId, userId);
        return this.userRolesDao.selectObjs(queryWrapper);
    }

    // 根据userid查出roleName
    public List<String> getRolesListByUserId(Integer userId) {
        List<Long> rolesIdList = getRolesIdListByUserId(userId);
        // 联立roleDao查找
        LambdaQueryWrapper<Roles> queryWrapperRole = new LambdaQueryWrapper<>();
        // 确保角色未被锁定
        queryWrapperRole.select(Roles::getName)
                .eq(Roles::getAvailable, 1)
                .in(Roles::getId, rolesIdList);
        return this.rolesDao.selectObjs(queryWrapperRole);
    }
}
