package com.pi4.wayclient.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Ticket_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(mappedBy = "ticketDetail")
    private Ticket ticket;


    //TODO: replace column for relationship when Product gets coded
    //TODO: replace String for Product when coded
    @OneToOne(mappedBy = "ticketDetail")
    private Product product;

    //TODO: replace String for Service when coded
    //TODO: replace column for relationship when Service gets coded
    @Column
    private String service;

    @Column(nullable = false)
    private String status;

    @JsonFormat(pattern="dd/MM/yyyy")
    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String description;
}
