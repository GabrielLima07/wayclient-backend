package com.pi4.wayclient.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Ticket_type {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(mappedBy = "ticketType")
    private Ticket ticket;

    @Column
    private String description;

    //TODO: replace String for Department when coded
    //TODO: replace column for relationship when Department gets coded
    @Column
    private String department;
}
