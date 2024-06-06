package com.pi4.wayclient.repository;

import com.pi4.wayclient.model.TicketDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TicketDetailRepository extends JpaRepository<TicketDetail, UUID> {
}
