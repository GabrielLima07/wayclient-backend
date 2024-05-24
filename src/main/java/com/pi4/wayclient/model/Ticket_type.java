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


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    private Department department;
}
