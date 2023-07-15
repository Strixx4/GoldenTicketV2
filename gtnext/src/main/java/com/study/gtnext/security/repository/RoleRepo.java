package com.study.gtnext.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.gtnext.security.entity.Role;

public interface RoleRepo  extends JpaRepository<Role, Long> {
}
