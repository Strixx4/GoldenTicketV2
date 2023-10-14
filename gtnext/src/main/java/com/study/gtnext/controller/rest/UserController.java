package com.study.gtnext.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.gtnext.service.CustomerService;

import lombok.Data;

@RestController
@Data
@RequestMapping("/api/auth")
public class UserController {
    private final CustomerService customerService;

    @PostMapping("/signin")
    public ResponseEntity<?> getDetails(Authentication authentication) {
        try {
            return ResponseEntity.ok(customerService.findByUser((authentication.getPrincipal()).toString()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad Credentials. Retry!");
        }
    }
}
