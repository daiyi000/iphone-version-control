package com.aeasy.iphoneversioncontrol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/register", "/api/auth/login").permitAll() // 注册和登录公开
                .anyRequest().permitAll() // 其他接口也允许访问（不要求验证）
            )
            .csrf(csrf -> csrf.disable()) // 关闭 CSRF 保护，方便测试
            .formLogin(login -> login.defaultSuccessUrl("/")) // 启用表单登录（可选）
            .logout(logout -> logout.logoutUrl("/api/auth/logout").logoutSuccessUrl("/"));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 使用 Bcrypt 进行密码加密
    }
}
