package com.zq.demo.pojo.community;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Fans implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "f_fan_id", type = IdType.ASSIGN_ID)
    private Integer f_fan_id;

    private Integer f_up_id;

    private Integer f_cr_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date f_time;

    private Integer f_status;


}
