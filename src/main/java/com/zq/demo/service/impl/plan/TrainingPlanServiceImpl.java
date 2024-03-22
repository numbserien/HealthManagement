package com.zq.demo.service.impl.plan;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
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
import java.util.Arrays;
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
    public TrainingPlan init(String name,Long creatorId){
        TrainingPlan trainingPlan = new TrainingPlan(name);
        trainingPlan.setTp_u_id(creatorId);
        this.planDao.insert(trainingPlan);
        return trainingPlan;
    }
//    修改状态
    public Integer setStatus(Long id,Integer status){
        LambdaUpdateWrapper<TrainingPlan> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(TrainingPlan::getTp_id,id);
        wrapper.set(TrainingPlan::getTp_status,status).set(TrainingPlan::getTp_update_time, new Date());
        return planDao.update(null,wrapper);
    }
//    条件搜索
    public IPage<TrainingPlan> search(int page,
                                      int count ,
                                      String search,
                                      String orderItem,
                                      String orderType,
                                      Long selfId,
                                      Long[] authorIds){
        // 可选排序条件
        String[] condition = {"tp_create_time","tp_update_time","tp_score","tp_status","tp_u_id","tp_days","tp_name"};
        if (!Arrays.asList(condition).contains(orderItem)){
            orderItem = null;
        }
        QueryWrapper<TrainingPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .and(wrapper->wrapper.like(search!=null,"tp_name",search)
                        .in(authorIds!=null,"tp_u_id",authorIds))
                .and(wrapper->wrapper.eq(authorIds==null || Arrays.asList(authorIds).contains(selfId),"tp_u_id",selfId)
                        .or()
                        // 公开
                        .eq("tp_type",1))
                .orderBy(orderItem!=null,!"desc".equals(orderType),orderItem);
        return pageControl(page, count, queryWrapper);
    }
//    分页查询模块
    private <T> IPage<TrainingPlan> pageControl(int page, int count, Wrapper<T> wrapper){
        IPage<TrainingPlan> pageC = new Page<>(page,count);
        if (wrapper instanceof QueryWrapper) {
           return planDao.selectPage(pageC, (QueryWrapper<TrainingPlan>) wrapper);
        } else if (wrapper instanceof LambdaQueryWrapper) {
           return planDao.selectPage(pageC, (LambdaQueryWrapper<TrainingPlan>) wrapper);
        }else
            return null;
    }
//    用户个人修改训练计划
    public Integer updateByUser(TrainingPlan trainingPlan,Long u_id){
        LambdaUpdateWrapper<TrainingPlan> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(TrainingPlan::getTp_u_id,u_id) // 本人更改
                .eq(TrainingPlan::getTp_id,trainingPlan.getTp_id())
                .in(TrainingPlan::getTp_status,0,1); // 确保非上线
        wrapper.set(trainingPlan.getTp_name()!=null,TrainingPlan::getTp_name,trainingPlan.getTp_name())
                .set(trainingPlan.getTp_type()!=null,TrainingPlan::getTp_type,trainingPlan.getTp_type())
                .set(TrainingPlan::getTp_update_time,new Date());
        return planDao.update(null,wrapper);
    }
//    判断该用户是否有权限编辑这个trainingPlan
    public TrainingPlan selectByUIdAndTPId(Long u_id,Long tp_id){
        LambdaQueryWrapper<TrainingPlan> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TrainingPlan::getTp_id,tp_id)
                .eq(TrainingPlan::getTp_u_id,u_id);
        return planDao.selectOne(wrapper);
    }
}
