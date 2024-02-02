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
public class ChatRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cr_id", type = IdType.ASSIGN_ID)
    private Integer cr_id;

    private String cr_name;

    private Integer cr_level;

    private LocalDateTime cr_create_time;

    private Integer cr_u_id;

    private Integer cr_is_password;

    private String cr_password;

    private Integer cr_online;

    private Integer cr_limit;

    private Integer cr_status;


}
