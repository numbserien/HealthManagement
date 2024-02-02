package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.Version;
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
public class CampusMembership implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cm_id", type = IdType.ASSIGN_ID)
    private Integer cm_id;

    private String cm_name;

    private Integer cm_role;

    private LocalDate cm_birthday;

    private Integer cm_m_id;

    private Integer cm_s_id;

    private String cm_class;


}
