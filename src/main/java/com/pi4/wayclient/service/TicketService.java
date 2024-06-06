package com.pi4.wayclient.service;

import com.pi4.wayclient.model.Ticket;
import com.pi4.wayclient.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> retrieveTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> retrieveTicketById(UUID id) {
        return ticketRepository.findById(id);
    }

    public Ticket updateTicket(UUID id, Ticket updatedTicket) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    ticket.setTicketType((updatedTicket.getTicketType() == null) ? ticket.getTicketType() : updatedTicket.getTicketType());
                    ticket.setTicketDetail((updatedTicket.getTicketDetail() == null) ? ticket.getTicketDetail() : updatedTicket.getTicketDetail());
                    return ticketRepository.save(ticket);
                })
                .orElseGet(() -> ticketRepository.save(updatedTicket));
    }

    public boolean deleteTicket(UUID id) {
        try {
            ticketRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
