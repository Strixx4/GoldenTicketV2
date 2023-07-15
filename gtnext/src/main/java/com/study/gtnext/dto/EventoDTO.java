package com.study.gtnext.dto;

import java.util.List;

import lombok.Data;

@Data
public class EventoDTO {
    private long id;
    private String nome;
	private String tipologia;
	private String genere;
	private String data;
	private String locandina;
	private LocalitaDTO localita;
    private List<ArtistaDTO> artisti;
}
