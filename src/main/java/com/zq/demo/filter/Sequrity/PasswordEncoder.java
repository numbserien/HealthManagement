package com.zq.demo.filter.Sequrity;

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
//        TODO 获取前端的加密后的密码会将 + => 空格
//        String pwd = rawPassword.toString();
        String pwd = rawPassword.toString().replace(" ", "+");
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

    /**
     * 注册的时候使用此方法对密码加密
     *
     * @param rawPassword
     * @return
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return super.encode(rawPassword);
    }
}
