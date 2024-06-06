package com.pi4.wayclient.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TicketType {
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
