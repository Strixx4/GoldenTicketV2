package com.study.gtnext.dto;

import lombok.Data;

@Data
public class CarrelloDTO {
    private Long id;
    private String identificativo;
    private double prezzo;
    private EventoDTO evento;
}
