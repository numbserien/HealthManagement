package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
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
public class Fans implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "f_fan_id", type = IdType.ASSIGN_ID)
    private Integer f_fan_id;

    private Integer f_up_id;

    private Integer f_cr_id;

    private LocalDateTime f_time;

    private Integer f_status;


}
