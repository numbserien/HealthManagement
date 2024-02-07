package com.zq.demo.controller.utils;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.map.MapUtil;
import com.google.code.kaptcha.Producer;
import com.zq.demo.pojo.sys.Result;
import com.zq.demo.util.Const;
import com.zq.demo.util.JwtUtils;
import com.zq.demo.util.RedisUtils02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/utils")
public class UtilsController {
    @Autowired
    Producer producer;
    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/captcha")
    public Result Captcha() throws IOException {
        String key = UUID.randomUUID().toString();
        String code = producer.createText();

        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);

        String str = "data:image/jpeg;base64,";

        String base64Img = str + Base64Encoder.encode(outputStream.toByteArray());

        RedisUtils02.hset(Const.CAPTCHA_KEY, key, code, 120);

        return Result.success(
                MapUtil.builder()
                        .put("userKey", key)
                        .put("captchaImg", base64Img)
                        .build()
        );
    }
}
