package com.pi4.wayclient.controller;

import com.pi4.wayclient.model.TicketDetail;
import com.pi4.wayclient.service.TicketDetailService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public TicketDetail postTicketDetail(TicketDetail ticketDetail) {
        return ticketDetailService.createTicketDetail(ticketDetail);
    }

    @GetMapping
    public List<TicketDetail> getTicketDetail() {
        return ticketDetailService.retrieveTicketsDetails();
    }

    @GetMapping("/{id}")
    public Optional<TicketDetail> getTicketDetail(UUID id) {
        return ticketDetailService.retrieveTicketDetailById(id);
    }

    @PutMapping("/{id}")
    public TicketDetail putTicketDetail(@PathVariable UUID id, @RequestBody TicketDetail ticketDetail) {
        return ticketDetailService.updateTicketDetail(id, ticketDetail);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTicketDetail(@PathVariable UUID id) {
        return ticketDetailService.deleteTicketDetail(id);
    }
}
