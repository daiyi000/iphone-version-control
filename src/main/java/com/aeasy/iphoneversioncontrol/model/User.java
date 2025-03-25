package com.aeasy.iphoneversioncontrol.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_user")
@Getter @Setter // 确保包含 Getter 和 Setter
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password; // 🔹 需要 getter 和 setter

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
