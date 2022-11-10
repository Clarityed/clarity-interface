package com.clarity.clarityinterface.Controller;

import com.clarity.apiclientsdk.Model.User;
import com.clarity.apiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取名称 API
 *
 * @author: clarity
 * @date: 2022年11月10日 14:40
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/")
    public String getNameByGet(String name) {
        return "GET 你的名字是：" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是：" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        if (request == null) {
            throw new RuntimeException("请求不存在");
        }
        String accessKey = request.getHeader("accessKey");
        String body = request.getHeader("body");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        // todo 实际情况应该是去数据库中查询是否已分配给用户
        if (!"clarity".equals(accessKey)) {
            throw new RuntimeException("无权限");
        }
        // todo 随机数实际上是更具有意义的，可以存在 Redis 中
        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限");
        }
        // todo 时间戳的判断，时间和当前时间不能超过 5 分钟
        // timestamp
        // todo 实际情况中是从数据库中查出 secretKey
        String serverSign = SignUtils.getSign(body, "abcdefgh");
        if (!serverSign.equals(sign)) {
            throw new RuntimeException("无权限");
        }
        return "POST 用户名字是：" + user.getName();
    }

}
