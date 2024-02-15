package com.zq.demo.pojo;

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
@TableName("ScoreLog")
public class ScoreLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sl_id", type = IdType.ASSIGN_ID)
    private Integer sl_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sl_time;

    private Integer sl_u_id;

    private Integer sl_old_scores;

    private Integer sl_change_scores;

    private Integer sl_new_scores;

    private Integer sl_score_event;

    private Integer sl_change_type;


}
