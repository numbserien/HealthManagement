package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
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

    @TableId(value = "dp_pi_id", type = IdType.ASSIGN_ID)
    private Integer dp_pi_id;

    private Integer dp_pc_id;

    private LocalTime dp_duration;

    private LocalTime dp_start;

    private LocalTime dp_deadline;


}
