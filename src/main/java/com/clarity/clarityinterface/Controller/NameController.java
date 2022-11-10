package com.clarity.clarityinterface.Controller;

import com.clarity.clarityinterface.Model.User;
import org.springframework.web.bind.annotation.*;

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
    public String getUsernameByPost(@RequestBody User user) {
        return "POST 用户名字是：" + user.getName();
    }

}
