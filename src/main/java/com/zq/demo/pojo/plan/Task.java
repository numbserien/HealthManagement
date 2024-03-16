package com.zq.demo.pojo.plan;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "t_id", type = IdType.ASSIGN_ID)
    private Integer t_id;

    private Integer t_pp_id;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date t_start_day;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date t_deadline;

    private Integer t_u_id;

    private Integer t_combo_day;

    private Integer t_is_public;

    private Integer t_status;


}
