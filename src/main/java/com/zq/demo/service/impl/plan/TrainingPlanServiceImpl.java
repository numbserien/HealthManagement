package com.zq.demo.service.impl.plan;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zq.demo.pojo.plan.TrainingPlan;
import com.zq.demo.dao.plan.TrainingPlanDao;
import com.zq.demo.service.interfaces.plan.ITrainingPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GL
 * @since 2024-02-09
 */
@Service
public class TrainingPlanServiceImpl extends ServiceImpl<TrainingPlanDao, TrainingPlan> implements ITrainingPlanService {
    @Resource
    private TrainingPlanDao planDao;
//    创建初始化计划
    public TrainingPlan init(String name,Integer createId){
        TrainingPlan trainingPlan = new TrainingPlan(name);
        trainingPlan.setTp_u_id(createId);
        this.planDao.insert(trainingPlan);
        System.out.println(trainingPlan);
        return trainingPlan;
    }
//    修改状态
    public Integer setStatus(Integer id,Integer status){
        LambdaUpdateWrapper<TrainingPlan> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(TrainingPlan::getTp_id,id);
        wrapper.set(TrainingPlan::getTp_status,status).set(TrainingPlan::getTp_update_time, new Date());
        int update = planDao.update(wrapper);
        return update;
    }
//    条件搜索
    public IPage<TrainingPlan> search(int page,
                                      int count ,
                                      String search,
                                      String orderItem,
                                      String orderType,
                                      Integer selfId){
        QueryWrapper<TrainingPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .and(search!=null,wrapper->wrapper.like("tp_name",search))
                .and(wrapper->wrapper.eq("tp_u_id",selfId)
                        .or()
                        // 公开
                        .eq("tp_type",1))
                .orderBy(orderItem!=null,!"desc".equals(orderType),orderItem);
        return pageControl(page, count, queryWrapper);
    }
//    分页查询模块
    private IPage<TrainingPlan> pageControl(int page,int count,QueryWrapper<TrainingPlan> queryWrapper){
        IPage<TrainingPlan> pageC = new Page<>(page,count);
        planDao.selectPage(pageC,queryWrapper);
        return pageC;
    }
//    用户个人修改训练计划
    public Integer updateByUser(TrainingPlan trainingPlan,Integer u_id){
        LambdaUpdateWrapper<TrainingPlan> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(TrainingPlan::getTp_u_id,u_id) // 本人更改
                .eq(TrainingPlan::getTp_id,trainingPlan.getTp_id())
                .in(TrainingPlan::getTp_status,0,1); // 非上线修改
        wrapper.set(trainingPlan.getTp_name()!=null,TrainingPlan::getTp_name,trainingPlan.getTp_name())
                .set(trainingPlan.getTp_type()!=null,TrainingPlan::getTp_type,trainingPlan.getTp_type())
                .set(TrainingPlan::getTp_update_time,new Date());
        return planDao.update(null,wrapper);
    }
}
