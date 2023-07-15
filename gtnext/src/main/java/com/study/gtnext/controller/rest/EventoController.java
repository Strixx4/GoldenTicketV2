package com.study.gtnext.controller.rest;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Page<EventoDTO> findLimit(
         @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ){
        return eService.FindWithLimit(page,size);
    }
}
