package com.study.gtnext.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="localita")
public class Localita implements GenericEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String citta;
	private String zona;
	private int posti;
	private String indirizzo;

    //il mapped by si mette nell'entità dove non c'è foreign key
    // fetchType.LAZY indica che la lista viene riempita solo nel
    //      momento in cui essa viene chiamata
    @OneToMany(mappedBy = "localita",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Evento> eventi;
}
