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
public class Major implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "m_id", type = IdType.ASSIGN_ID)
    private Integer m_id;

    private String m_name;

    private String m_site;

    private Integer m_m_id;

    private Integer m_c_id;


}
