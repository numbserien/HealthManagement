package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author GL
 * @since 2024-01-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DayPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dp_pi_id", type = IdType.ASSIGN_ID)
    private Integer dp_pi_id;

    private Integer dp_pc_id;

    private LocalTime dp_duration;

    private LocalTime dp_start;

    private LocalTime dp_deadline;


}
