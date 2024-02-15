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
@TableName("ChatContent")
public class ChatContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cc_id", type = IdType.ASSIGN_ID)
    private Integer cc_id;

    private String cc_content;

    private Integer cc_u_id;

    private Integer cc_cr_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cc_time;

    private Integer cc_reply_id;

    private Integer cc_status;


}
