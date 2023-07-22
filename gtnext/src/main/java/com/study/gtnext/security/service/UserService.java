package com.study.gtnext.security.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.study.gtnext.security.converter.UserConverter;
import com.study.gtnext.security.dto.UserDTO;
import com.study.gtnext.security.entity.User;
import com.study.gtnext.security.repository.UserRepo;
import com.study.gtnext.service.GenericService;

@Service
public class UserService extends GenericService<User, UserConverter, UserRepo, UserDTO, Long> {
    private final PasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepo repository, UserConverter converter, PasswordEncoder bCryptPasswordEncoder) {
        super(converter, repository);
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserDTO NewUser(UserDTO userDTO) throws Exception {

        try {
            Optional<User> user1 = getRepository().findByUsername(userDTO.getUsername());
            userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
            if (user1.isPresent()) {
                throw new Exception("Utente già registrato,impossibile continuare");
            }
            User user2 = getConverter().convert(userDTO);

            String verification_code = (int) (Math.random() * 1000000) + "";
            if (verification_code.length() != 6) {
                for (int i = 0; i < 6 - verification_code.length(); i++)
                    verification_code += "0";
            }
            user2.setVerificationCode(verification_code);
            UserDTO userDTO1 = getConverter().reverseConvert(getRepository().save(user2));
            return userDTO1;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    public UserDTO findByName(String name) throws Exception {
        Optional<User> user = getRepository().findByUsername(name);
        if (user.isEmpty())
            throw new Exception("utente non trovato, moooolto strano");
        return getConverter().reverseConvert(user.get());
    }

    public UserDTO findUserById(Long id) throws Exception {
        Optional<User> user = getRepository().findById(id);
        if (!user.isPresent()) {

            throw new Exception("utente non trovato durante la fase di " +
                    "validazione");

        }

        return getConverter().reverseConvert(user.get());

    }
}