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
 * @since 2024-02-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ScoreLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sl_id", type = IdType.ASSIGN_ID)
    private Integer sl_id;

    private LocalDateTime sl_time;

    private Integer sl_u_id;

    private Integer sl_old_scores;

    private Integer sl_change_scores;

    private Integer sl_new_scores;

    private Integer sl_score_event;

    private Integer sl_change_type;


}
