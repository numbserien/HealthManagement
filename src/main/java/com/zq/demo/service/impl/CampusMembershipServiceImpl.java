package com.zq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zq.demo.dao.CampusMembershipDao;
import com.zq.demo.pojo.CampusMembership;
import com.zq.demo.service.ICampusMembershipService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author GL
 * @since 2024-01-31
 */
@Service
public class CampusMembershipServiceImpl extends ServiceImpl<CampusMembershipDao, CampusMembership> implements ICampusMembershipService {
}
