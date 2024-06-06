package com.pi4.wayclient.controller;

import com.pi4.wayclient.model.TicketType;
import com.pi4.wayclient.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("ticketType")
public class TicketTypeController {
    private final TicketTypeService ticketTypeService;

    @Autowired
    public TicketTypeController(TicketTypeService ticketTypeService) {
        this.ticketTypeService = ticketTypeService;
    }

    @PostMapping
    public TicketType postTicketType(TicketType ticketType) {
        return ticketTypeService.createTicketType(ticketType);
    }

    @GetMapping
    public List<TicketType> getTicketType() {
        return ticketTypeService.retrieveTicketsTypes();
    }

    @GetMapping("/{id}")
    public Optional<TicketType> getTicketType(@PathVariable UUID id) {
        return ticketTypeService.retrieveTicketTypeById(id);
    }

    @PutMapping("/{id}")
    public TicketType putTicketType(@PathVariable UUID id, @RequestBody TicketType ticketType) {
        return ticketTypeService.updateTicketType(id, ticketType);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTicketType(@PathVariable UUID id) {
        return ticketTypeService.deleteTicketType(id);
    }
}
