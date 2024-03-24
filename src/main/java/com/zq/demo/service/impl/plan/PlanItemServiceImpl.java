package com.zq.demo.service.impl.plan;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zq.demo.pojo.plan.PlanItem;
import com.zq.demo.dao.plan.PlanItemDao;
import com.zq.demo.service.interfaces.plan.IPlanItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GL
 * @since 2024-02-09
 */
@Service
public class PlanItemServiceImpl extends ServiceImpl<PlanItemDao, PlanItem> implements IPlanItemService {
    @Resource
    private PlanItemDao planItemDao;
    //    创建计划项
    public PlanItem init(PlanItem planItem){
        planItemDao.insert(planItem);
        return planItem;
    }

    //    根据pi_ids并通过tp_id分组判断是否有两组，有两组就说明非相同的计划项
    public boolean isSameTp(Long[] pi_ids){
        QueryWrapper<PlanItem> wrapper = new QueryWrapper<>();
        wrapper.select("pi_tp_id","COUNT(*) as count")
                .in("pi_id",pi_ids)
                .groupBy("pi_tp_id");
        List<Map<String, Object>> aaa = planItemDao.selectMaps(wrapper);

        return aaa.size()==1;
    }
//    根据tp_id查找计划项
    public List<PlanItem> selectByTpId(Long tp_Id){
        QueryWrapper<PlanItem> wrapper = new QueryWrapper<>();
        wrapper.eq("pi_tp_id",tp_Id)
                .orderByAsc("pi_order");
        return planItemDao.selectList(wrapper);
    }
//    判断计划项是否属于该用户
    public boolean auth(Long pi_id,Long u_id){
        LambdaQueryWrapper<PlanItem> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PlanItem::getPi_id,pi_id)
                .eq(PlanItem::getPi_creator_id,u_id);
        return planItemDao.selectCount(wrapper)==1;
    }
}
