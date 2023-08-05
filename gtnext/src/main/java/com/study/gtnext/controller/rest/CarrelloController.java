package com.study.gtnext.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.gtnext.service.CarrelloService;

import lombok.Data;

@RestController
@RequestMapping("/api/carrello")
@Data
public class CarrelloController {
    private final CarrelloService cs;

    @GetMapping("/")
    public ResponseEntity<?> carrelloView(@RequestParam("user") String u) {
        return cs.findByUser(u);
    }
     @GetMapping("/mock")
    public ResponseEntity<?> carrelloStrixx() {
        return cs.findByUser("strixx");
    }
}
