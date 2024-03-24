package com.zq.demo.pojo.plan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;

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
@TableName("DayPlan")
public class DayPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dp_id", type = IdType.ASSIGN_ID)
    private Long dp_id;

    private Long dp_pi_id;

    private Long dp_pc_id;

    private Long dp_creator_id;

    private Integer dp_duration;

    private Time dp_start;

    private Time dp_deadline;


}
