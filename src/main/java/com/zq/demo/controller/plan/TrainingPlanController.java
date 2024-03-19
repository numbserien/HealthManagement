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
//    初始化新计划书
    @PostMapping("/")
    public Result makePlan(HttpServletRequest request, @RequestParam String name){
        Integer creatorId = jwtUtils.getAuthId(request);
//        应该不会存在无法解析jwt的情况
//        if (creatorId==-1){
//            return Result.failure("认证错误，请重新登录！");
//        }
        TrainingPlan trainingPlan = service.init(name,creatorId);
        if (trainingPlan!=null){
            return Result.success(trainingPlan);
        }else
            return Result.failure("新建失败，请重试！");
    }
//    更新计划  ps:只允许本人操作
//    TODO 更新计划的名字和是否公开
    @PutMapping("/")
    public Result updatePlan(@RequestBody TrainingPlan trainingPlan,HttpServletRequest request){
        Integer authId = jwtUtils.getAuthId(request);
        Integer updateCount = service.updateByUser(trainingPlan,authId);
        if (updateCount!=0){
            return Result.success("共改变 "+updateCount+" 条数据");
        }else
            return Result.failure("修改失败，请重试");
    }
//    更改计划的状态
    @PatchMapping("/{tp_id}")
    public Result changeStatus(@PathVariable("tp_id") Integer tp_id,
                               @RequestParam("status") Integer status,
                               HttpServletRequest request){
//        动手者id
        Integer authId = jwtUtils.getAuthId(request);
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
    public Result getPlanById(@PathVariable("tp_id") Integer tp_id, HttpServletRequest request){
        TrainingPlan byId = service.getById(tp_id);
        if (byId==null){
            return Result.failure(ResultCode.NOTFOUND);
        }
        if (byId.getTp_type()==0){
            // 私有项目
            Integer authId = jwtUtils.getAuthId(request);
            if (Objects.equals(byId.getTp_u_id(), authId)){
                return Result.success(byId);
            }
            return Result.failure("该训练计划未公开");
        }
        return Result.success(byId);
    }
    @GetMapping("/")
    public Result getPlans(@RequestParam(value = "search",required = false) String search,
                           @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                           @RequestParam(value = "count",required = false,defaultValue = "10") Integer count,
                           @RequestParam(value = "orderItem",required = false) String orderItem,
                           @RequestParam(value = "orderType",required = false) String orderType,
                           HttpServletRequest request){
        Integer authId = jwtUtils.getAuthId(request);
//        TODO 考虑错误情况
        IPage<TrainingPlan> IPage = service.search(page, count, search, orderItem, orderType, authId);
        return Result.success(IPage);
    }
}

