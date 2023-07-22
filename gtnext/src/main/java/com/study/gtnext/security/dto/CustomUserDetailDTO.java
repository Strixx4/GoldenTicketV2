package com.study.gtnext.security.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.study.gtnext.security.entity.Role;
import com.study.gtnext.security.entity.User;

public class CustomUserDetailDTO implements UserDetails {
    private User user;
    // private Long idDip;
    public CustomUserDetailDTO(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = user.getRoles();
        // idDip= user.getDipendente().getId();
        // System.out.println("sono nei ruoli");

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        // System.out.println(roles);
        for (Role role : roles) {
            // System.out.println(role.toString());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
    }
    
}
