package com.study.gtnext.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "carrello")
@Data
public class Carrello implements GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String identificativo;
    private double prezzo;


    @ManyToOne
    @JoinColumn(name = "event_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
