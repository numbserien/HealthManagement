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
public class GamePlayer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "gp_id", type = IdType.ASSIGN_ID)
    private Integer gp_id;

    private Integer gp_u_id;

    private Integer gp_g_id;

    private Integer gp_role;

    private String gp_role_tag;

    private LocalDateTime gp_judgment_time;


}
