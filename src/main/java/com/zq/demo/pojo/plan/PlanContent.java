package com.zq.demo.pojo.plan;

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
@TableName("PlanContent")
public class PlanContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pc_id", type = IdType.ASSIGN_ID)
    private Long pc_id;

    private Long pc_clone_id;

    private String pc_name;

    private String pc_description;

    private String pc_type;

    private String pc_site;

    private Long pc_u_id;

    private String pc_remark;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date pc_create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date pc_update_time;

    private Integer pc_open;

}
