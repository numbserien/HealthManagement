package com.zq.demo.service.impl;

import com.zq.demo.pojo.Task;
import com.zq.demo.dao.TaskDao;
import com.zq.demo.service.ITaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author GL
 * @since 2024-01-31
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskDao, Task> implements ITaskService {

}
