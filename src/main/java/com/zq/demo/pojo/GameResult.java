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
public class GameResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gr_id", type = IdType.ASSIGN_ID)
    private Integer gr_id;

    private LocalDateTime gr_time;

    private String gr_description;

    private Integer gr_g_id;

    private Integer gr_recorder_id;


}
