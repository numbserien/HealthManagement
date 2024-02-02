package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
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
public class TrainingPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "tp_id", type = IdType.ASSIGN_ID)
    private Integer tp_id;

    private String tp_name;

    private Integer tp_days;

    private Integer tp_u_id;

    private LocalDateTime tp_create_time;

    private Integer tp_type;

    private Integer tp_completeness;

    private Integer tp_likes;

    private Integer tp_status;

    private Integer tp_score;


}
