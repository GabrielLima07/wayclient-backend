package com.pi4.wayclient.service;

import com.pi4.wayclient.model.TicketDetail;
import com.pi4.wayclient.repository.TicketDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketDetailService {
    private final TicketDetailRepository ticketDetailRepository;

    @Autowired
    public TicketDetailService(TicketDetailRepository ticketDetailRepository) {
        this.ticketDetailRepository = ticketDetailRepository;
    }

    public TicketDetail createTicketDetail(TicketDetail ticketDetail) {
        return ticketDetailRepository.save(ticketDetail);
    }

    public List<TicketDetail> retrieveTicketsDetails() {
        return ticketDetailRepository.findAll();
    }

    public Optional<TicketDetail> retrieveTicketDetailById(UUID id) {
        return ticketDetailRepository.findById(id);
    }

    public TicketDetail updateTicketDetail(UUID id, TicketDetail updatedTicketDetail) {
        return ticketDetailRepository.findById(id)
                .map(ticketDetail -> {
                    ticketDetail.setService((updatedTicketDetail.getService() == null) ? ticketDetail.getService() : updatedTicketDetail.getService());
                    ticketDetail.setProduct((updatedTicketDetail.getProduct() == null) ? ticketDetail.getProduct() : updatedTicketDetail.getProduct());
                    ticketDetail.setDate((updatedTicketDetail.getDate() == null) ? ticketDetail.getDate() : updatedTicketDetail.getDate());
                    ticketDetail.setStatus((updatedTicketDetail.getStatus() == null) ? ticketDetail.getStatus() : updatedTicketDetail.getStatus());
                    ticketDetail.setDescription((updatedTicketDetail.getDescription() == null) ? ticketDetail.getDescription() : updatedTicketDetail.getDescription());
                    return ticketDetailRepository.save(ticketDetail);
                })
                .orElseGet(() -> ticketDetailRepository.save(updatedTicketDetail));
    }

    public boolean deleteTicketDetail(UUID id) {
        try {
            ticketDetailRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
