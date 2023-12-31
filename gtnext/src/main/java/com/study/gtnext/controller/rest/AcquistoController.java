package com.study.gtnext.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.gtnext.dto.AcquistoDTO;
import com.study.gtnext.service.AcquistoService;
import com.study.gtnext.service.CarrelloService;

import lombok.Data;

@RestController
@RequestMapping("/api/acquisto")
@Data
public class AcquistoController {
    private final AcquistoService acquistoService;
    private final CarrelloService carrelloService;

    @GetMapping("/{id}")
    public List<AcquistoDTO> readAll(@PathVariable Long id) {
        return acquistoService.findByUser(id);
    }

    @PostMapping("/acquista")
    public void acquista(@RequestBody Map<String, List<String>> map) {
        acquistoService.saveList(map.get("ids"));
        carrelloService.deleteList(map.get("ids"));

    }
}
