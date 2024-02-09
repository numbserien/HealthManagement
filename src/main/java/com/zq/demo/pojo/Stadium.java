package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.Version;
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
public class Stadium implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer s_id;

    private String s_name;

    private String s_site;

    private Integer s_type;

    private Integer s_status;

    private Integer s_u_id;


}
