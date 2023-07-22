package com.study.gtnext.security;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
public class UserRetriever {
    @SneakyThrows
    public String getUserName() {
        try {
            return SecurityContextHolder.getContext().getAuthentication().getName();
        }catch (Exception e){
            throw new Exception("utente non autenticato");
        }
    }
}
