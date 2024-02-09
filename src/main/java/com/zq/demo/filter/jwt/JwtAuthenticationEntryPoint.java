package com.zq.demo.filter.jwt;

import cn.hutool.json.JSONUtil;
import com.zq.demo.pojo.sys.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 验证失败的路线
 * <p>
 * 当BasicAuthenticationFilter认证失败的时候会进入AuthenticationEntryPoint，我们定义JWT认证失败处理器JwtAuthenticationEntryPoint，
 * 使其实现AuthenticationEntryPoint接口，该接口只有一个commence方法，表示认证失败的处理，我们重写该方法，向前端返回错误信息，不论是什么原因，
 * JWT认证失败，我们就要求重新登录，所以返回的错误信息为请先登录
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        outputStream.write(JSONUtil.toJsonStr(Result.failure("请先登录")).getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
