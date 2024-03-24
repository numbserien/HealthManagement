package com.zq.demo.controller.plan;


import com.zq.demo.pojo.plan.PlanItem;
import com.zq.demo.pojo.plan.TrainingPlan;
import com.zq.demo.pojo.sys.Result;
import com.zq.demo.pojo.sys.ResultCode;
import com.zq.demo.service.impl.plan.PlanItemServiceImpl;
import com.zq.demo.service.impl.plan.TrainingPlanServiceImpl;
import com.zq.demo.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author GL
 * @since 2024-02-09
 */
@RestController
@RequestMapping("/user/planItems")
public class PlanItemController {
    @Autowired
    private PlanItemServiceImpl service;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TrainingPlanServiceImpl trainingPlanService;
//    创建计划项
    @PostMapping("/")
    public Result init(@RequestBody PlanItem planItem){
        Long authId = jwtUtils.getAuthId(request);
        if (trainingPlanService.selectByUIdAndTPId(authId,planItem.getPi_tp_id())!=null){
            // 确认有权限
            planItem.setPi_creator_id(authId);
            service.init(planItem);
            return Result.success(planItem);
        }else {
            return Result.failure(ResultCode.AUTHERROR);
        }
    }
//   支持批量和单独更新计划项(调整顺序)
    @PutMapping("/")
    public Result updateToOne(@RequestBody ArrayList<PlanItem> planItems){
        if (planItems==null || planItems.size()==0){
            return Result.failure("参数传入错误，请重试");
        }
//        确保是同一个计划中的计划项
        Long[] longs = planItems.stream().map(PlanItem::getPi_id).toArray(Long[]::new);
        boolean allTpIdSame = service.isSameTp(longs);
        if(allTpIdSame){
            boolean b = service.updateBatchById(planItems);
            if (b){
                return Result.success("保存成功");
            }else
                return Result.failure("调整失败，请重试。");
        }else
            return Result.failure("请确保计划项属于同一任务");
    }
//    删除计划项
    @DeleteMapping("/{tp_id}/{pi_id}")
    private Result deleteById(@PathVariable("pi_id") Long pi_id,@PathVariable("tp_id") Long tp_id){
        Long authId = jwtUtils.getAuthId(request);
        if (trainingPlanService.selectByUIdAndTPId(authId,tp_id)!=null){
            service.removeById(pi_id);
//            TODO 这里涉及到级联删除
            return Result.success("删除成功");
        }
        else return Result.failure(ResultCode.AUTHERROR);
    }
//    查询计划项及其内容 TODO 结合后续的DayPlan 查询
    @GetMapping("/{pi_id}")
    private Result getById(@PathVariable Long pi_id){
        return Result.success("接口待完成！");
    }
//    根据tp_id查找
    @GetMapping("/")
    private Result select(@RequestParam Long tp_id){
        List<PlanItem> planItems = service.selectByTpId(tp_id);
        return Result.success(planItems);
    }
}

