package com.study.gtnext.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.gtnext.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{
    public Customer findByUsername(String username);
}
