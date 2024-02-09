package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
 * @since 2024-02-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "t_id", type = IdType.ASSIGN_ID)
    private Integer t_id;

    private Integer t_pp_id;

    private LocalDate t_start_day;

    private LocalDate t_deadline;

    private Integer t_u_id;

    private Integer t_combo_day;

    private Integer t_next_job;

    private Integer t_is_public;

    private Integer t_status;


}
