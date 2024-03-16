package com.zq.demo.service.impl.plan;

import com.zq.demo.pojo.plan.Task;
import com.zq.demo.dao.plan.TaskDao;
import com.zq.demo.service.service.plan.ITaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GL
 * @since 2024-02-09
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskDao, Task> implements ITaskService {

}
