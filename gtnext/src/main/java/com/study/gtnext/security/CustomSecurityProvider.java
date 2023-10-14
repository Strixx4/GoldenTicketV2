package com.study.gtnext.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.study.gtnext.entity.Customer;
import com.study.gtnext.service.CustomerService;

import lombok.Data;

@Data
@Component
public class CustomSecurityProvider implements AuthenticationProvider {
    private final CustomerService customerService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String user = authentication.getName();
        String password = authentication.getCredentials().toString();

        Customer customer = customerService.findCustomer(user);
        if (passwordEncoder.matches(password, customer.getPassword())) {
            List<GrantedAuthority> auths = new ArrayList<>();
            customer.getRoles().forEach(role -> {
                auths.add((new SimpleGrantedAuthority(role.getName())));
            });
            return new UsernamePasswordAuthenticationToken(user, password, auths);
        } else {

            throw new BadCredentialsException("bad credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
