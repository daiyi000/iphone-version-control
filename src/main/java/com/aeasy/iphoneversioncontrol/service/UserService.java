package com.aeasy.iphoneversioncontrol.service;

import com.aeasy.iphoneversioncontrol.model.Role;
import com.aeasy.iphoneversioncontrol.model.User;
import com.aeasy.iphoneversioncontrol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(String username, String password, Role role) {
        if (userRepository.findByUsername(username).isPresent()) {
            return "用户名已存在！";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // 密码加密
        user.setRole(role);
        userRepository.save(user);
        return "注册成功！";
    }

    public boolean authenticate(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
    
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
