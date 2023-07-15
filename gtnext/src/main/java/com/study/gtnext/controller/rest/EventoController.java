package com.study.gtnext.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.gtnext.dto.EventoDTO;
import com.study.gtnext.service.EventoService;

import lombok.Data;

@Data
@RestController
@RequestMapping("api/eventi/")
public class EventoController {
    private final EventoService eService;

    @GetMapping("all")
    public List<EventoDTO> all(){
        return eService.findAll();
    }
    @GetMapping("limit")
    public List<EventoDTO> findLimit(){
        return eService.FindWithLimit();
    }
}
