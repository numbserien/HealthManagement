package com.zq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zq.demo.dao.RolesPermissionsDao;
import com.zq.demo.pojo.RolesPermissions;
import com.zq.demo.service.IRolesPermissionsService;
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
public class RolesPermissionsServiceImpl extends ServiceImpl<RolesPermissionsDao, RolesPermissions> implements IRolesPermissionsService {

    //    TODO 根据角色名列表返回权限路径
    public List<String> getPermissionListByRoleList(List<String> roles) {
        return new ArrayList<>();
    }
}
