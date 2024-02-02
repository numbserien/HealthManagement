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
 * @since 2024-01-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer u_id;

    private String u_name;

    private String u_password;

    private String u_nick_name;

    private String u_img;

    private Integer u_score;

    private Integer u_cm_id;

    private String u_role;

    private String u_phone;

    private Integer u_status;


}
