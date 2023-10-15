package com.study.gtnext.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "acquisti")
public class Acquisto implements GenericEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String identificativo;
    private double prezzo;

    @Temporal(TemporalType.DATE)
    private Date data_acquisto;


    @ManyToOne
    @JoinColumn(name = "event_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
