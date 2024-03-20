package com.zq.demo.controller.plan;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zq.demo.pojo.plan.PlanContent;
import com.zq.demo.pojo.sys.Result;
import com.zq.demo.pojo.sys.ResultCode;
import com.zq.demo.service.impl.plan.PlanContentServiceImpl;
import com.zq.demo.util.JwtUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
@RequestMapping("/user/planContents")
public class PlanContentController {
    @Resource
    private JwtUtils jwtUtils;
    @Resource
    private PlanContentServiceImpl service;
    @Resource
    private HttpServletRequest request;
//    创建内容
    @PostMapping("/")
    public Result init(@RequestBody PlanContent planContent){
        Long authId = jwtUtils.getAuthId(request);
        if (service.findByUIdAndPlanName(authId,planContent.getPc_name())!=null){
            return Result.failure("个人计划内容名重用，请更改后重试");
        }
        planContent.setPc_u_id(authId);
        service.init(planContent);
        return Result.success(planContent);
    }
//    修改内容
    @PutMapping("/{pc_id}")
    public Result updatePC(@PathVariable("pc_id") Long pc_id,@RequestBody PlanContent planContent){
        Long authId = jwtUtils.getAuthId(request);
//        判断是否为本人修改
        if (service.findByUIdAndPlanId(authId,pc_id)==null){
            return Result.failure("权限错误，不能修改他人创作");
        }
//      判断修改的计划名不能重复
        PlanContent checkObj = service.findByUIdAndPlanName(authId,planContent.getPc_name());
        if (checkObj!=null){
            if (!Objects.equals(checkObj.getPc_id(), pc_id)){
                return Result.failure("个人计划内容名重用，请更改后重试");
            }
        }
//      确保修改的对应id
        planContent.setPc_id(pc_id);
//      确保创建时间和制作人不修改
        planContent.setPc_u_id(null);
        planContent.setPc_create_time(null);

        planContent.setPc_update_time(new Date());
        if (service.updateById(planContent)){
            return Result.success();
        }else {
            return Result.failure("操作失败,请重试");
        }
    }
//    更改 公开权限
    @PatchMapping("/{pc_id}")
    public Result changeOpen(@PathVariable("pc_id") Long pc_id,@RequestParam("is_open") Integer is_open){
        Long authId = jwtUtils.getAuthId(request);
        Integer updateCount = service.changeOpen(authId, pc_id, is_open);
        if (updateCount!=0){
          return   Result.success("修改成功，"+ updateCount+"条数据更改");
        }
        return Result.failure(ResultCode.AUTHERROR);
    }
//    条件查找
    @GetMapping("/")
    public Result getPlanContents(@RequestParam(value = "authorIds",required = false) Long[] authorIds,
                                  @RequestParam(value = "search",required = false) String search,
                                  @RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                                  @RequestParam(value = "count",required = false,defaultValue = "10") Integer count,
                                  @RequestParam(value = "orderItem",required = false) String orderItem,
                                  @RequestParam(value = "orderType",required = false) String orderType
    ){
        Long authId = jwtUtils.getAuthId(request);
        IPage<PlanContent> IPage = service.search(page, count, search, orderItem, orderType, authId,authorIds);
        return Result.success(IPage);
    }
//    根据pc_id查找
    @GetMapping("/{pc_id}")
    public Result getPlanContentById(@PathVariable(value = "pc_id") Long pc_id){
        Long authId = jwtUtils.getAuthId(request);
        PlanContent planContent = service.searchById(pc_id, authId);
        if (planContent!=null){
            return  Result.success(planContent);
        }
        return Result.failure(ResultCode.NOTFOUND);
    }
}

