package com.zq.demo.pojo.plan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author GL
 * @since 2024-02-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("TrainingPlan")
public class TrainingPlan implements Serializable {
    public TrainingPlan(String name){
        this.tp_name = name;
        Date date = new Date();
        this.tp_update_time=date;
        this.tp_create_time = date;
        this.setTp_type(0);
        this.setTp_status(0);
    }
    public TrainingPlan(){}
    private static final long serialVersionUID = 1L;

    @TableId(value = "tp_id", type = IdType.ASSIGN_ID)
    private Integer tp_id;

    private Integer tp_clone_id;

    private String tp_name;

    private Integer tp_days;

    private Integer tp_u_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date tp_create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date tp_update_time;
    // 是否公开 0不公开 1公开
    private Integer tp_type;

    private Integer tp_completeness;

    private Integer tp_likes;
    // 状态 0创建中 1创建完成 2审核中 3试用期 4允许上线
    private Integer tp_status;

    private Integer tp_score;


}
