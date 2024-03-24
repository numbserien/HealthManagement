package com.zq.demo.pojo.plan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
@TableName("PlanItem")
public class PlanItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "pi_id", type = IdType.ASSIGN_ID)
    private Long pi_id;
    private Long pi_creator_id;

    private Integer pi_order;

    private String pi_description;

    private Long pi_tp_id;
    private Integer pi_combo_day=1;


}
