package com.zq.demo.service.impl.plan;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.zq.demo.pojo.plan.DayPlan;
import com.zq.demo.dao.plan.DayPlanDao;
import com.zq.demo.pojo.plan.PlanItem;
import com.zq.demo.service.interfaces.plan.IDayPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Time;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GL
 * @since 2024-02-09
 */
@Service
public class DayPlanServiceImpl extends ServiceImpl<DayPlanDao, DayPlan> implements IDayPlanService {
    @Resource
    private DayPlanDao dao;
    @Resource
    private PlanItem planItem;

    public Boolean isNotCoincide(DayPlan dayPlan) {
        if (dayPlan.getDp_deadline()==null && dayPlan.getDp_start()==null){
            return true;
        }
        LambdaQueryWrapper<DayPlan> wrapper = new LambdaQueryWrapper<>();
        if (dayPlan.getDp_deadline()!=null && dayPlan.getDp_start()!=null){
//            满足重复
            wrapper.and(wrapper1->wrapper1.between(DayPlan::getDp_deadline,dayPlan.getDp_start(),dayPlan.getDp_deadline())
                    .or()
                    .between(DayPlan::getDp_start,dayPlan.getDp_start(),dayPlan.getDp_deadline()));
        }else {
            Time item =dayPlan.getDp_deadline()!=null? dayPlan.getDp_deadline():dayPlan.getDp_start();
//            满足重复
            wrapper.and(wrapper1->wrapper1.le(DayPlan::getDp_start,item).ge(DayPlan::getDp_deadline,item));
        }
        wrapper.ne(dayPlan.getDp_id()!=null,DayPlan::getDp_id,dayPlan.getDp_id());
        Long aLong = dao.selectCount(wrapper);
        return aLong==0;
    }

    public DayPlan init(DayPlan dayPlan) {
        dao.insert(dayPlan);
        return dayPlan;
    }
//    判断权限后插入
    public Integer updateAuth(DayPlan dayPlan,Long u_id){
        LambdaUpdateWrapper<DayPlan> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(DayPlan::getDp_creator_id,u_id);
        return dao.update(dayPlan,wrapper);
    }
    public boolean auth(Long dp_id,Long u_id){
        return dao.selectCount(new LambdaQueryWrapper<DayPlan>().eq(DayPlan::getDp_id,dp_id).eq(DayPlan::getDp_creator_id,u_id))==1;
    }
//    批量删除并权限删除
    public int deleteAuth(Long[] dp_ids,Long u_id){
        LambdaUpdateWrapper<DayPlan> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(DayPlan::getDp_creator_id,u_id)
                .in(DayPlan::getDp_id,dp_ids);
        return dao.delete(wrapper);
    }
//    查询一天的计划安排
    public List<DayPlan> getOneDay(Long pi_id){
        LambdaQueryWrapper<DayPlan> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DayPlan::getDp_pi_id,pi_id)
                .orderByAsc(DayPlan::getDp_start);
        return dao.selectList(wrapper);
    }
}
