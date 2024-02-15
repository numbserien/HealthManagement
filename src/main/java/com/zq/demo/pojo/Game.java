package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "g_id", type = IdType.ASSIGN_ID)
    private Integer g_id;

    private String g_name;

    private String g_description;

    private Integer g_organizer_id;

    private String g_face_url;

    private String g_site;

    private Integer g_type;

    private Integer g_level;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Data g_start_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Data g_end_time;

    private Integer g_limit_people;

    private Integer g_fee;

    private Integer g_all_fee;

    private Integer g_is_chat;

    private Integer g_cr_id;

    private Integer g_status;


}
