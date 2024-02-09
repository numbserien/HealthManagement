package com.zq.demo.filter.jwt;

import com.zq.demo.util.Const;
import com.zq.demo.util.RSAUtils;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码加密解密：PasswordEncoder
 */
@NoArgsConstructor
public class PasswordEncoder extends BCryptPasswordEncoder {

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // 接收到的前端的密码
        String pwd = rawPassword.toString();
        // 进行rsa解密
        try {
            pwd = RSAUtils.decryptByPrivateKey(Const.RsaPrivateKey, pwd);
        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage());
        }
        if (encodedPassword != null && !encodedPassword.isEmpty()) {
//            在后端再使用BCrypt加密
            return BCrypt.checkpw(pwd, encodedPassword);
        } else {
            return false;
        }
    }
}
