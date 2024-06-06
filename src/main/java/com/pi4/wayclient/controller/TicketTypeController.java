package com.pi4.wayclient.controller;

import com.pi4.wayclient.model.TicketType;
import com.pi4.wayclient.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TicketType> postTicketType(TicketType ticketType) {
        TicketType newTicketType = ticketTypeService.createTicketType(ticketType);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTicketType);
    }

    @GetMapping
    public ResponseEntity<List<TicketType>> getTicketType() {
        List<TicketType> ticketTypeList = ticketTypeService.retrieveTicketsTypes();
        return ResponseEntity.status(HttpStatus.OK).body(ticketTypeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TicketType>> getTicketType(@PathVariable UUID id) {
        Optional<TicketType> ticketType = ticketTypeService.retrieveTicketTypeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketType> putTicketType(@PathVariable UUID id, @RequestBody TicketType ticketType) {
        TicketType updatedTicketType = ticketTypeService.updateTicketType(id, ticketType);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTicketType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketType(@PathVariable UUID id) {
        boolean deleted = ticketTypeService.deleteTicketType(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
