package com.study.gtnext.controller.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.gtnext.dto.CustomerDTO;
import com.study.gtnext.service.CustomerService;

import lombok.Data;

@RestController
@Data
public class UserController {
    private final CustomerService cs;

    @PostMapping
    public CustomerDTO getDetails(@RequestParam("user")String username){
        try{
            return cs.findByUser(username);
        }catch(Exception e){
            //! da sostituire con una bad user credentials
            return null;
        }

    }
}
