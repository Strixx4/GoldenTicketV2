package com.study.gtnext.security.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Set<RoleDTO> roles = new HashSet<>();

    @Data
    public static class UserDTOLogged {
        private String username;
        private String cognome;
        private String nome;
        private Set<RoleDTO> roles = new HashSet<>();

        public UserDTOLogged(UserDTO userDTO) {
            this.roles = userDTO.getRoles();
            this.username = userDTO.getUsername();

        }

    }
}
