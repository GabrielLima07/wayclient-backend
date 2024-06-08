package com.pi4.wayclient.repository;

import com.pi4.wayclient.model.TicketDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TicketDetailRepository extends JpaRepository<TicketDetail, UUID> {
    List<TicketDetail> findByStatus(String status);
    List<TicketDetail> findByDate(LocalDate date);
    List<TicketDetail> findByDateBetween(LocalDate startDate, LocalDate endDate);
    List<TicketDetail> findByService(String service);
    List<TicketDetail> findByDescriptionContaining(String keyword);

    @Query("SELECT td FROM TicketDetail td WHERE td.status = :status AND td.date = :date")
    List<TicketDetail> findByStatusAndDate(@Param("status") String status, @Param("date") LocalDate date);

    @Query(value = "SELECT * FROM TicketDetail WHERE service = :service AND date = :date", nativeQuery = true)
    List<TicketDetail> findByServiceAndDate(@Param("service") String service, @Param("date") LocalDate date);
}
