package com.aeasy.iphoneversioncontrol.repository;

import com.aeasy.iphoneversioncontrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
