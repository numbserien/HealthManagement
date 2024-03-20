package com.zq.demo.service.impl.plan;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zq.demo.pojo.plan.PlanContent;
import com.zq.demo.dao.plan.PlanContentDao;
import com.zq.demo.service.interfaces.plan.IPlanContentService;
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
public class PlanContentServiceImpl extends ServiceImpl<PlanContentDao, PlanContent> implements IPlanContentService {

    @Resource
    private PlanContentDao pcDao;

    public void init(PlanContent planContent) {
        Date createTime = new Date();
        planContent.setPc_create_time(createTime);
        planContent.setPc_update_time(createTime);
        pcDao.insert(planContent);
    }
//    根据用户id和计划名查找
    public PlanContent findByUIdAndPlanName(Long u_id,String planName){
        LambdaQueryWrapper<PlanContent> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PlanContent:: getPc_u_id,u_id)
                .eq(PlanContent::getPc_name,planName);
        return pcDao.selectOne(wrapper);
    }
//    根据用户id和计划id查找
    public PlanContent findByUIdAndPlanId(Long u_id,Long pc_id){
        LambdaQueryWrapper<PlanContent> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PlanContent:: getPc_u_id,u_id)
                .eq(PlanContent::getPc_id,pc_id);
        return pcDao.selectOne(wrapper);
    }
//    更改是否公开权限
    public Integer changeOpen(Long u_id,Long pc_id,Integer type){
        LambdaUpdateWrapper<PlanContent> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(PlanContent::getPc_id,pc_id)
                .eq(PlanContent::getPc_u_id,u_id);
        wrapper.set(PlanContent::getPc_type,type);
        return pcDao.update(null, wrapper);
    }
    //    分页查询模块
    private <T> IPage<PlanContent> pageControl(int page, int count, Wrapper<T> wrapper){
        IPage<PlanContent> pageC = new Page<>(page,count);
        if (wrapper instanceof QueryWrapper) {
            return pcDao.selectPage(pageC, (QueryWrapper<PlanContent>) wrapper);
        } else if (wrapper instanceof LambdaQueryWrapper) {
            return pcDao.selectPage(pageC, (LambdaQueryWrapper<PlanContent>) wrapper);
        }else
            return null;
    }
//    条件搜索 TODO 合并通过u_id查找和条件查询
    public IPage<PlanContent> search(Integer page,
                                     Integer count,
                                     String search,
                                     String orderItem,
                                     String orderType,
                                     Long authId,
                                     Long[] authorIds){
        // 可选排序条件
        String[] condition = {"pc_create_time","pc_update_time","pc_site","pc_type","pc_name","pc_u_id"};
        if (!Arrays.asList(condition).contains(orderItem)){
            orderItem = null;
        }
        QueryWrapper<PlanContent> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .and(wrapper->wrapper.like(search!=null,"pc_name",search).in(authorIds!=null && authorIds.length!=0,"pc_u_id",authorIds))
                .and(wrapper->wrapper.eq(authorIds!=null && (authorIds.length==0 || Arrays.asList(authorIds).contains(authId)),"pc_u_id",authId)
                        .or()
                        // 公开
                        .eq("pc_open",1))
                .orderBy(orderItem!=null,!"desc".equals(orderType),orderItem);
//        TODO 有时间设置返回值
        return pageControl(page, count, queryWrapper);
    }
//    根据内容id查看详情
    public PlanContent searchById(Long pc_id,Long authorId){
        LambdaQueryWrapper<PlanContent> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PlanContent::getPc_id,pc_id)
                .and(wrapper1->wrapper1.eq(PlanContent::getPc_type,1)
                        .or()
                        .eq(PlanContent::getPc_u_id,authorId));
        return pcDao.selectOne(wrapper);
    }
}
