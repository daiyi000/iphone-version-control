package com.aeasy.iphoneversioncontrol.controller;

import com.aeasy.iphoneversioncontrol.model.Role;
import com.aeasy.iphoneversioncontrol.model.User;
import com.aeasy.iphoneversioncontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        // 将角色转换为大写再转成 Role 枚举
        Role role = Role.valueOf(request.get("role").toUpperCase());
        String response = userService.registerUser(username, password, role);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        boolean isAuthenticated = userService.authenticate(username, password);
        return isAuthenticated ? ResponseEntity.ok("登录成功") : ResponseEntity.status(401).body("用户名或密码错误");
    }
    
    @GetMapping("/userinfo")
    public ResponseEntity<?> getUserInfo(@RequestParam String username) {
        Optional<User> userOpt = userService.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // 你可以只返回角色或返回整个 User
            // 如果只想返回 { "role": "PUBLISHER" } 这种结构，可以自己封装
            Map<String, Object> result = new HashMap<>();
            result.put("username", user.getUsername());
            result.put("role", user.getRole());
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
