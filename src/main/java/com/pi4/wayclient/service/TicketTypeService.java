package com.pi4.wayclient.service;

import com.pi4.wayclient.model.TicketType;
import com.pi4.wayclient.repository.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketTypeService {
    private final TicketTypeRepository ticketTypeRepository;

    @Autowired
    public TicketTypeService(TicketTypeRepository ticketTypeRepository) {
        this.ticketTypeRepository = ticketTypeRepository;
    }

    public TicketType createTicketType(TicketType ticketType) {
        return ticketTypeRepository.save(ticketType);
    }

    public List<TicketType> retrieveTicketsTypes() {
        return ticketTypeRepository.findAll();
    }

    public Optional<TicketType> retrieveTicketTypeById(UUID id) {
        return ticketTypeRepository.findById(id);
    }

    public TicketType updateTicketType(UUID id, TicketType updatedTicketType) {
        return ticketTypeRepository.findById(id)
                .map((ticketType) -> {
                    ticketType.setTicket((updatedTicketType.getTicket() == null) ? ticketType.getTicket() : updatedTicketType.getTicket());
                    ticketType.setDescription((updatedTicketType.getDescription() == null) ? ticketType.getDescription() : updatedTicketType.getDescription());
                    ticketType.setDepartment((updatedTicketType.getDepartment() == null) ? ticketType.getDepartment() : updatedTicketType.getDepartment());
                    return ticketTypeRepository.save(ticketType);
                })
                .orElseGet(() -> ticketTypeRepository.save(updatedTicketType));
    }

    public boolean deleteTicketType(UUID id) {
        try {
            ticketTypeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
