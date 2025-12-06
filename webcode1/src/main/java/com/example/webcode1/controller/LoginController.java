package com.example.webcode1.controller;

import com.example.webcode1.entity.UserInfo;
import com.example.webcode1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin // 允许跨域（方便本地测试前端）
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/login")
    public Map<String, Object> login(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        String password = payload.get("password");

        Map<String, Object> result = new HashMap<>();

        // 1. 查询用户
        UserInfo user = userRepository.findByUsername(username);

        // 2. 校验逻辑
        if (user == null) {
            result.put("success", false);
            result.put("message", "用户不存在");
        } else if (!user.getPassword().equals(password)) {
            result.put("success", false);
            result.put("message", "密码错误");
        } else {
            result.put("success", true);
            result.put("message", "登录成功！欢迎 " + user.getUsername());
            // 这里通常会生成 Token 返回给前端
        }

        return result;
    }
}