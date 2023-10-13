package com.study.gtnext.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.gtnext.dto.CarrelloDTO;
import com.study.gtnext.service.CarrelloService;

import lombok.Data;

@RestController
@RequestMapping("/api/carrello")
@Data
public class CarrelloController {
    private final CarrelloService cs;

    @GetMapping("/{id}")
    public List<CarrelloDTO> carrelloView(@PathVariable Long id) {
        return cs.findById(id);
    }
     @GetMapping("/mock")
    public List<CarrelloDTO> carrelloStrixx() {
        return cs.findById(Long.parseLong("1"));
    }
}
