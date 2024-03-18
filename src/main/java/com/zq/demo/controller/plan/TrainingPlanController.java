package com.zq.demo.controller.plan;


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
@RequestMapping("/user/trainingPlan")
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
//    TODO 按道理只允许修改计划名、执行天数、类型，并且判断计划项目是否为未上线状态，上线期间也不能更新
    @PostMapping("/update")
    public Result updatePlan(@RequestBody TrainingPlan trainingPlan,HttpServletRequest request){
        Integer authId = jwtUtils.getAuthId(request);
        if (!Objects.equals(authId, trainingPlan.getTp_u_id())){
            return Result.failure(ResultCode.AUTHERROR);
        }
        service.updateById(trainingPlan);
        return Result.success(trainingPlan);
    }
//    更改计划的状态
    @PostMapping("/{tp_id}/{status}")
    public Result changeStatus(@PathVariable("tp_id") Integer tp_id, @PathVariable("status") Integer status, HttpServletRequest request){
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
}

