package com.study.gtnext.security.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.study.gtnext.converter.Converter;
import com.study.gtnext.security.dto.RoleDTO;
import com.study.gtnext.security.dto.UserDTO;
import com.study.gtnext.security.entity.Role;
import com.study.gtnext.security.entity.User;

import lombok.Data;

//Il converter si occupa di trasformare un Entity in un DTO e viceversa
@Service
@Data
public class UserConverter implements Converter<User, UserDTO> {
    private final RoleConverter roleConverter;
    @Override
    public User convert(UserDTO u) {
        User d = new User();
        d.setId(u.getId());
        d.setUsername(u.getUsername());
        List<Role> listaRole = new ArrayList<>();
        u.getRoles().stream().forEach(
            x -> {
                listaRole.add(roleConverter.convert(x));
            }
        );
        d.setRoles(listaRole);

        return d;
    }

    @Override
    public UserDTO reverseConvert(User i) {
        UserDTO d = new UserDTO();
        d.setId(i.getId());
        d.setUsername(i.getUsername());
        
        Set<RoleDTO> listaRole = new HashSet<>();
        i.getRoles().stream().forEach(
            x -> {
                listaRole.add(roleConverter.reverseConvert(x));
            }
        );
        d.setRoles(listaRole);

        return d;
    }
    
}
