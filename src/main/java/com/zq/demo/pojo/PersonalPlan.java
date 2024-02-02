package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
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
