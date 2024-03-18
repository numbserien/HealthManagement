package com.zq.demo.service.impl.plan;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.zq.demo.pojo.plan.TrainingPlan;
import com.zq.demo.dao.plan.TrainingPlanDao;
import com.zq.demo.service.interfaces.plan.ITrainingPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
