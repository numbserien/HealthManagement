package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalTime;
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
public class CompletionDay implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer cd_is_place;

    private String cd_site;

    private Integer cd_occasion;

    private Integer cd_is_finish;

    private LocalTime cd_start_time;

    private LocalTime cd_end_time;

    private Integer cd_t_id;

    private Integer cd_day;


}
