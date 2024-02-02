package com.zq.demo.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码错误的异常
 */
public class CaptchaException extends AuthenticationException {

    public CaptchaException(String msg) {
        super(msg);
    }
}
