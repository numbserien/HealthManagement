package com.zq.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalTime;

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
@TableName("CompletionDay")
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
