package com.study.gtnext.controller.rest;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        return cs.findByUser(id);
    }

    @PostMapping("/{id}/aggiungi")
    public boolean aggiungiCarrello(@PathVariable Long id, @RequestBody Map<String, String> map) {
        return cs.save(id, Long.parseLong(map.get("idEvento")));
    }

    @DeleteMapping("/{id}/elimina")
    public void eliminaDaCarrello(@PathVariable Long id, @RequestParam("bigliettoId") Long bigliettoId) {
        cs.delete(bigliettoId);
    }
}
