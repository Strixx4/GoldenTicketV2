package com.study.gtnext.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.gtnext.security.entity.User;

public interface UserRepo  extends JpaRepository<User, Long> {
    public Optional<User> findByUsername(String user);
    public Optional<User> findByVerificationCode(String uuid);
}
