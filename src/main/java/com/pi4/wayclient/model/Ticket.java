package com.pi4.wayclient.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class Ticket {

    @Column
    private UUID id;
    @Column
    private Customer customer;
   @Column
    private Ticket_type ticketType;
   @Column
    private Ticket_Detail ticketDetail;

}
