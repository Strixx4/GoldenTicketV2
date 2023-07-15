package com.study.gtnext.security.converter;

import org.springframework.stereotype.Service;

import com.study.gtnext.converter.Converter;
import com.study.gtnext.security.dto.RoleDTO;
import com.study.gtnext.security.entity.Role;


@Service
public class RoleConverter implements Converter<Role, RoleDTO> {

    @Override
    public Role convert(RoleDTO u) {
        Role d = new Role();
        d.setId(u.getId());
        d.setName(u.getName());
        return d;
    }

    @Override
    public RoleDTO reverseConvert(Role i) {

        RoleDTO d = new RoleDTO();
        d.setId(i.getId());
        d.setName(i.getName());
        return d;
    }
    
}
