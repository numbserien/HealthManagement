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
@TableName("GamePlayer")
public class GamePlayer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gp_id", type = IdType.ASSIGN_ID)
    private Integer gp_id;

    private Integer gp_u_id;

    private Integer gp_g_id;

    private Integer gp_role;

    private String gp_role_tag;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gp_judgment_time;


}
