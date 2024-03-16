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
@TableName("PersonalPlan")
public class PersonalPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pp_id", type = IdType.ASSIGN_ID)
    private Integer pp_id;

    private Integer pp_u_id;

    private Integer pp_tp_id;

    private Integer pp_is_collection;

    private Integer pp_times;

    private Integer pp_status;


}
