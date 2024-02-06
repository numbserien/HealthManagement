package com.zq.demo.filter.captcha;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zq.demo.exception.CaptchaException;
import com.zq.demo.filter.jwt.LoginFailureHandler;
import com.zq.demo.util.Const;
import com.zq.demo.util.RedisUtils02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CaptchaFilter extends OncePerRequestFilter {

    @Autowired
    LoginFailureHandler loginFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException, ServletException, IOException {

        String url = httpServletRequest.getRequestURI();
        if ("/login".equals(url) && httpServletRequest.getMethod().equals("POST")) {
            // 校验验证码
            try {
                validate(httpServletRequest);
            } catch (CaptchaException e) {
                // 交给认证失败处理器
                loginFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    // 校验验证码逻辑
    private void validate(HttpServletRequest httpServletRequest) {
        String code = httpServletRequest.getParameter("code");
        String key = httpServletRequest.getParameter("userKey");

        if (StringUtils.isBlank(code) || StringUtils.isBlank(key)) {
            throw new CaptchaException("验证码错误");
        }

        if (!code.equals(RedisUtils02.hget(Const.CAPTCHA_KEY, key))) {
            throw new CaptchaException("验证码错误");
        }

        // 若验证码正确, 删除验证码
        RedisUtils02.hdel(Const.CAPTCHA_KEY, key);
    }
}
