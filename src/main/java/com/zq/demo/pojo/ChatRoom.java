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
@TableName("ChatRoom")
public class ChatRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cr_id", type = IdType.ASSIGN_ID)
    private Integer cr_id;

    private String cr_name;

    private Integer cr_level;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cr_create_time;

    private Integer cr_u_id;

    private Integer cr_is_password;

    private String cr_password;

    private Integer cr_online;

    private Integer cr_limit;

    private Integer cr_status;


}
