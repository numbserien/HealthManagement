package com.zq.demo.service.impl.plan;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zq.demo.pojo.plan.TrainingPlan;
import com.zq.demo.dao.plan.TrainingPlanDao;
import com.zq.demo.service.interfaces.plan.ITrainingPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public TrainingPlan init(String name,Integer createId){
        LambdaQueryWrapper<TrainingPlan> wrapper = new LambdaQueryWrapper<>();
        TrainingPlan trainingPlan = new TrainingPlan(name);
        trainingPlan.setTp_u_id(createId);
        this.planDao.insert(trainingPlan);
        System.out.println(trainingPlan);
        return trainingPlan;
    }
}
