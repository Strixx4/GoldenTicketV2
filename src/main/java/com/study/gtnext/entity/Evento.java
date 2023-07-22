package com.study.gtnext.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="eventi")
public class Evento implements GenericEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
	private String tipologia;
	private String genere;
	private String data;
	private String giornoSettimana;
	private String ora;
	private String locandina;

    @ManyToOne
    @JoinColumn(name="idLocalita")
	private Localita localita;

    @ManyToMany
    private List<Artista> artisti;


}
