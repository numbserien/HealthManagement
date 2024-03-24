package com.zq.demo.controller.plan;


import com.zq.demo.pojo.plan.DayPlan;
import com.zq.demo.pojo.sys.Result;
import com.zq.demo.pojo.sys.ResultCode;
import com.zq.demo.service.impl.plan.DayPlanServiceImpl;
import com.zq.demo.service.impl.plan.PlanItemServiceImpl;
import com.zq.demo.util.JwtUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author GL
 * @since 2024-02-09
 */
@RestController
@RequestMapping("/user/dayPlans/")
public class DayPlanController {
    @Resource
    private DayPlanServiceImpl service;
    private PlanItemServiceImpl planItemService;
    @Resource
    private JwtUtils jwtUtils;
    @Resource
    private HttpServletRequest request;
//  新建
    @PostMapping("/")
    public Result init(@RequestBody DayPlan dayPlan){
        Long authId = jwtUtils.getAuthId(request);
//        判断是否有权限
        if (!planItemService.auth(dayPlan.getDp_pi_id(),authId)){
            return Result.failure(ResultCode.AUTHERROR);
        }
//        判断时间是否不重合
        if (service.isNotCoincide(dayPlan)){
//            时间不重复
            dayPlan.setDp_creator_id(authId);
            DayPlan init = service.init(dayPlan);
            return Result.success(init);
        }else{
            return Result.failure("时间重复，请重新设置");
        }
    }
//  更新
    @PutMapping("/")
    public Result update(@RequestBody DayPlan dayPlan){
        //    判断是否有权限
        if (service.auth(dayPlan.getDp_id(),jwtUtils.getAuthId(request))){
            return Result.failure(ResultCode.AUTHERROR);
        }
        //    判断时间是否不重合
        if (service.isNotCoincide(dayPlan)){
            service.updateById(dayPlan);
            return Result.success();
        }
        else return Result.failure("时间重复，请重新设置");
    }
//  批量删除
    @DeleteMapping("/")
    public Result delete(@RequestBody Long[] dp_ids){
        Long authId = jwtUtils.getAuthId(request);
        int count = service.deleteAuth(dp_ids,authId);
        if (count==dp_ids.length){
            return Result.success("删除 " +count+ " 条记录");
        }else return Result.failure(ResultCode.AUTHERROR);
    }
//    传入dp_pi_id 查看当天计划 TODO 结合planContent
    @GetMapping("/")
    public Result getDp(@RequestParam Long dp_id){
        return Result.success(service.getOneDay(dp_id));
    }
}