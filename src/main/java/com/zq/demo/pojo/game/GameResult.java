package com.zq.demo.pojo.game;

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
@TableName("GameResult")
public class GameResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gr_id", type = IdType.ASSIGN_ID)
    private Integer gr_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gr_time;

    private String gr_description;

    private Integer gr_g_id;

    private Integer gr_recorder_id;


}
