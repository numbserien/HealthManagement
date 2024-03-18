package com.zq.demo.service.impl.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zq.demo.dao.user.PermissionsDao;
import com.zq.demo.dao.user.RolesPermissionsDao;
import com.zq.demo.pojo.user.Permissions;
import com.zq.demo.pojo.user.RolesPermissions;
import com.zq.demo.service.interfaces.user.IRolesPermissionsService;
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
public class RolesPermissionsServiceImpl extends ServiceImpl<RolesPermissionsDao, RolesPermissions> implements IRolesPermissionsService {

    @Resource
    private RolesPermissionsDao rolesPermissionsDao;
    @Resource
    private PermissionsDao permissionsDao;

    //    根据角色Id列表返回权限路径
    public List<String> getPermissionListByRoleList(List<Long> rolesId) {
        LambdaQueryWrapper<RolesPermissions> queryWrapperRP = new LambdaQueryWrapper<>();
        queryWrapperRP.in(!rolesId.isEmpty(), RolesPermissions::getId, rolesId)
                .select(RolesPermissions::getPermissionId);
        List<Long> permissionIds = rolesPermissionsDao.selectObjs(queryWrapperRP);
        LambdaQueryWrapper<Permissions> queryWrapperR = new LambdaQueryWrapper<>();
        queryWrapperR.in(Permissions::getId, permissionIds)
                .eq(Permissions::getStatus, 1)
                .select(Permissions::getUrl);
        return permissionsDao.selectObjs(queryWrapperR);
    }
}
