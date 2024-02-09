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
public class Campus implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "c_id", type = IdType.ASSIGN_ID)
    private Integer c_id;

    private String c_name;

    private String c_site;

    private Integer c_level;


}
