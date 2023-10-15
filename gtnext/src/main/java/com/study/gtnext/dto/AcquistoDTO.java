package com.study.gtnext.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AcquistoDTO {
    private Long id;
    private String identificativo;
    private double prezzo;
    private Date data_acquisto;
    private EventoDTO evento;
}
