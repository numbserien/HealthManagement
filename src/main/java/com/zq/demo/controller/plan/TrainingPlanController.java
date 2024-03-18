package com.zq.demo.controller.plan;


import com.zq.demo.pojo.plan.TrainingPlan;
import com.zq.demo.pojo.sys.Result;
import com.zq.demo.service.impl.plan.TrainingPlanServiceImpl;
import com.zq.demo.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

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
    @PostMapping("/")
    public Result makePlan(HttpServletRequest request, @RequestParam String name){
        String jwt = String.valueOf(request.getHeader("Authorization"));
        System.out.println(jwt);
        Claims claimsByToken = jwtUtils.getClaimsByToken(jwt);
        System.out.println(claimsByToken.getSubject());
        TrainingPlan trainingPlan = service.init(name,new Integer(claimsByToken.getSubject()));
        if (trainingPlan!=null){
            return Result.success(trainingPlan);
        }else
            return Result.failure("新建失败，请重试！");
    }
}

