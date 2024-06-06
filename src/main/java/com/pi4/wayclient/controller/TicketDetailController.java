package com.pi4.wayclient.controller;

import com.pi4.wayclient.model.TicketDetail;
import com.pi4.wayclient.service.TicketDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("ticketDetail")
public class TicketDetailController {
    private final TicketDetailService ticketDetailService;

    @Autowired
    public TicketDetailController(TicketDetailService ticketDetailService) {
        this.ticketDetailService = ticketDetailService;
    }

    @PostMapping
    public ResponseEntity<TicketDetail> postTicketDetail(TicketDetail ticketDetail) {
        TicketDetail newTicketDetail = ticketDetailService.createTicketDetail(ticketDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTicketDetail);
    }

    @GetMapping
    public ResponseEntity<List<TicketDetail>> getTicketDetail() {
        List<TicketDetail> ticketDetailList = ticketDetailService.retrieveTicketsDetails();
        return ResponseEntity.status(HttpStatus.OK).body(ticketDetailList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TicketDetail>> getTicketDetail(UUID id) {
        Optional<TicketDetail> ticketDetail = ticketDetailService.retrieveTicketDetailById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDetail> putTicketDetail(@PathVariable UUID id, @RequestBody TicketDetail ticketDetail) {
        TicketDetail updatedTicketDetail = ticketDetailService.updateTicketDetail(id, ticketDetail);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTicketDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketDetail(@PathVariable UUID id) {
        boolean deleted = ticketDetailService.deleteTicketDetail(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
