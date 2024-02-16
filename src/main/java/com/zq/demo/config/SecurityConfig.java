package com.zq.demo.config;

import com.zq.demo.filter.Sequrity.LoginFailureHandler;
import com.zq.demo.filter.Sequrity.LoginSuccessHandler;
import com.zq.demo.filter.Sequrity.PasswordEncoder;
import com.zq.demo.filter.UsernamePasswordAuthentication.UserDetailServiceImpl;
import com.zq.demo.filter.captcha.CaptchaFilter;
import com.zq.demo.filter.jwt.JWTLogoutSuccessHandler;
import com.zq.demo.filter.jwt.JwtAccessDeniedHandler;
import com.zq.demo.filter.jwt.JwtAuthenticationEntryPoint;
import com.zq.demo.filter.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //    白名单不用登录访问的地方
    private static final String[] URL_WHITELIST = {
            "/login",
            "/logout",
            "/user/register",
            "/utils/captcha",
            "/favicon.ico"
    };
    @Autowired
    LoginFailureHandler loginFailureHandler;
    @Autowired
    LoginSuccessHandler loginSuccessHandler;
    @Autowired
    CaptchaFilter captchaFilter;
    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    JwtAccessDeniedHandler jwtAccessDeniedHandler;
    @Autowired
    UserDetailServiceImpl userDetailService;
    @Autowired
    JWTLogoutSuccessHandler jwtLogoutSuccessHandler;

    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        return new JwtAuthenticationFilter(authenticationManager());
    }

    @Bean
    PasswordEncoder PasswordEncoder() {
        return new PasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                // 登录配置
                .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)

                .and()
                // 退出登录
                .logout()
                .logoutSuccessHandler(jwtLogoutSuccessHandler)

                // 禁用session
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 配置拦截规则
                .and()
                .authorizeRequests()
                .antMatchers(URL_WHITELIST).permitAll()
                // 角色控制管理权限 SpEL表达式
                .anyRequest().access("@rbacService.hasPermission(request,authentication)")
                .antMatchers("/system/*").access("hasRole('admin') or hasAuthority('ROLE_admin')")
                // 记住我 TODO 前端提交 布尔值属性 -> rememberMe
                .and()
                .rememberMe()
                // 异常处理器
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                // 配置自定义的过滤器
                .and()
                .addFilter(jwtAuthenticationFilter())
                // 验证码过滤器放在UsernamePassword过滤器之前
                .addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class)
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }
}
