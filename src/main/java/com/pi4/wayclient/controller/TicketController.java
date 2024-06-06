package com.pi4.wayclient.controller;

import com.pi4.wayclient.model.Ticket;
import com.pi4.wayclient.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("ticket")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket postTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping
    public List<Ticket> getTicket() {
        return ticketService.retrieveTickets();
    }

    @GetMapping("/{id}")
    public Optional<Ticket> getTicket(@PathVariable UUID id) {
        return ticketService.retrieveTicketById(id);
    }

    @PutMapping("/{id}")
    public Ticket putTicket(@PathVariable UUID id, @RequestBody Ticket ticket) {
        return ticketService.updateTicket(id, ticket);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTicket(@PathVariable UUID id) {
        return ticketService.deleteTicket(id);
    }
}
