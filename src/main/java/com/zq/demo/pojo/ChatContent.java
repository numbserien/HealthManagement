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
public class ChatContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cc_id", type = IdType.ASSIGN_ID)
    private Integer cc_id;

    private String cc_content;

    private Integer cc_u_id;

    private Integer cc_cr_id;

    private LocalDateTime cc_time;

    private Integer cc_reply_id;

    private Integer cc_status;


}
