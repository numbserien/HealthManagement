package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

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
public class Campus implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "c_id", type = IdType.ASSIGN_ID)
    private Integer c_id;

    private String c_name;

    private String c_site;

    private Integer c_level;


}
