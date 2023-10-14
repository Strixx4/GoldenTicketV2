package com.study.gtnext.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.study.gtnext.security.filter.JWTGeneratorFilter;
import com.study.gtnext.security.filter.JWTValidatorFilter;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())

                .addFilterAfter(new JWTGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTValidatorFilter(), BasicAuthenticationFilter.class)

                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/js/**", "/css/**", "/img/**").permitAll()
                        .requestMatchers("/api/auth/signin").authenticated()
                        .requestMatchers("/","/index","carrello","acquisti","login").permitAll()
                        )
                .formLogin(
                        login -> login
                                .loginPage("/login").permitAll())
                .httpBasic(exception -> exception.authenticationEntryPoint((requests, response, authException) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                }));
        ;

        return http.build();
    }

    @Bean
    public PasswordEncoder pe() {
        return new BCryptPasswordEncoder();
    }
}
