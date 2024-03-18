package com.zq.demo.pojo.sys;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    //认证失败
    AUTHERROR(40300,"权限不足，非本人操作"),

    // 未找到资源
    NOTFOUND(40400,"未找到资源"),

    //成功提示码
    SUCCESS(20000, "成功"),

    //自定义失败信息
    FAILURE(50000, "失败"),

    //通用错误码 50001~50099
    PROGRAM_INSIDE_EXCEPTION(50001, "程序内部异常"),
    REQUEST_PARAM_ERROR(50002, "请求参数错误");

    private final Integer code;
    private final String message;
}

