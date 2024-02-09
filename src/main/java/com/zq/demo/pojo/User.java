package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 密码-MD5加密
     */
    private String password;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 头像
     */
    private String head_img;

    /**
     * 得分
     */
    private Integer score;

    /**
     * 绑定学校id
     */
    private Integer u_cm_id;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 账号状态: 1-正常；0-停用
     */
    private String status;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private LocalDateTime c_time;

    /**
     * 性别
     */
    private String sex;
}
