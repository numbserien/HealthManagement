package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2024-02-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PlanContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pc_id", type = IdType.ASSIGN_ID)
    private Integer pc_id;

    private String pc_description;

    private String pc_type;

    private String pc_site;

    private Integer pc_u_id;

    private String pc_remark;


}
