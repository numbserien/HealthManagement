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
@TableName("CampusMembership")
public class CampusMembership implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cm_id", type = IdType.ASSIGN_ID)
    private Integer cm_id;

    private String cm_name;

    private Integer cm_role;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date cm_birthday;

    private Integer cm_m_id;

    private Integer cm_s_id;

    private String cm_class;


}
