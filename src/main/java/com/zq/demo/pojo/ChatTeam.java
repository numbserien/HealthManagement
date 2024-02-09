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
public class ChatTeam implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ct_cr_id", type = IdType.ASSIGN_ID)
    private Integer ct_cr_id;

    private Integer ct_u_id;

    private Integer ct_status;


}
