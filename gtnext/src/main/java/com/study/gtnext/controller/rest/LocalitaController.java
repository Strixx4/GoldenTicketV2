package com.study.gtnext.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.gtnext.dto.Citta;
import com.study.gtnext.service.LocalitaService;

import lombok.Data;

@RestController
@RequestMapping("api/localita/")
@Data
public class LocalitaController {

    private final LocalitaService locService;

    @GetMapping("listacitta")
    public List<Citta> all(){
        return locService.listCitta();
    }
}
