package com.zq.demo.controller.plan;

//TODO 明日: 修改接口规范，查看RESTful风格

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zq.demo.pojo.plan.TrainingPlan;
import com.zq.demo.pojo.sys.Result;
import com.zq.demo.pojo.sys.ResultCode;
import com.zq.demo.service.impl.plan.TrainingPlanServiceImpl;
import com.zq.demo.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author GL
 * @since 2024-02-09
 */
@RestController
@RequestMapping("/user/trainingPlans")
public class TrainingPlanController {
    @Autowired
    private TrainingPlanServiceImpl service;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private HttpServletRequest request;
//    初始化新计划书
    @PostMapping("/")
    public Result makePlan( @RequestParam String name){
        Long creatorId = jwtUtils.getAuthId(request);
        TrainingPlan trainingPlan = service.init(name,creatorId);
        if (trainingPlan!=null){
            return Result.success(trainingPlan);
        }else
            return Result.failure("新建失败，请重试！");
    }
//    克隆计划书
    @PostMapping("/clone")
    public Result clonePlan(@RequestParam("tp_id") Integer CloneId){
        // TODO 克隆方式
        return Result.success("克隆接口还没写好");
    }
//    更新计划  ps:只允许本人操作
    @PutMapping("/")
    public Result updatePlan(@RequestBody TrainingPlan trainingPlan){
        Long authId = jwtUtils.getAuthId(request);
        Integer updateCount = service.updateByUser(trainingPlan,authId);
        if (updateCount!=0){
            return Result.success("共改变 "+updateCount+" 条数据");
        }else
            return Result.failure("修改失败，请重试");
    }
//    更改计划的状态
    @PatchMapping("/{tp_id}")
    public Result changeStatus(@PathVariable("tp_id") Long tp_id,
                               @RequestParam("status") Integer status){
//        动手者id
        Long authId = jwtUtils.getAuthId(request);
//      TODO 这里根据角色来做判断是否能操作改变状态

        Integer isSuccess = service.setStatus(tp_id, status);
        if (isSuccess!=0){
            return Result.success("修改成功");
        }else {
            return Result.failure("操作失败");
        }
    }
//    通过id寻找整个计划，包含内容信息 ps:非公开计划只能自己查看
//    TODO 返回整个计划信息
    @GetMapping("/{tp_id}")
    public Result getPlanById(@PathVariable("tp_id") Long tp_id){
        TrainingPlan byId = service.getById(tp_id);
        if (byId==null){
            return Result.failure(ResultCode.NOTFOUND);
        }
        if (byId.getTp_type()==0){
            // 私有项目
            Long authId = jwtUtils.getAuthId(request);
            if (Objects.equals(byId.getTp_u_id(), authId)){
                return Result.success(byId);
            }
            return Result.failure("该训练计划未公开");
        }
        return Result.success(byId);
    }
    @GetMapping("/")
    public Result getPlans(@RequestParam(value = "authorIds",required = false) Long[] authorIds,
                           @RequestParam(value = "search",required = false) String search,
                           @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                           @RequestParam(value = "count",required = false,defaultValue = "10") Integer count,
                           @RequestParam(value = "orderItem",required = false) String orderItem,
                           @RequestParam(value = "orderType",required = false) String orderType){
        Long authId = jwtUtils.getAuthId(request);
//        TODO 考虑错误情况
        IPage<TrainingPlan> IPage = service.search(page, count, search, orderItem, orderType, authId,authorIds);
        return Result.success(IPage);
    }
}

