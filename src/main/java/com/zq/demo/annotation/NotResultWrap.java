package com.zq.demo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * 不需要走返回数据统一包装的标签
 */
@Target({METHOD})
@Retention(RUNTIME)
public @interface NotResultWrap {
}
