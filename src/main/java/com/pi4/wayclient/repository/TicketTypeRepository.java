package com.pi4.wayclient.repository;

import com.pi4.wayclient.model.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

public interface TicketTypeRepository extends JpaRepository<TicketType, UUID> {
    List<TicketType> findByDescription(String description);
    List<TicketType> findByDepartment_Id(UUID departmentId);

    @Query("SELECT t FROM TicketType t WHERE t.description LIKE %:keyword%")
    List<TicketType> findByDescriptionContaining(@Param("keyword") String keyword);

    @Query("SELECT t FROM TicketType t JOIN t.department d WHERE d.name = :name")
    List<TicketType> findByDepartmentName(@Param("name") String name);

    @Query("SELECT t FROM TicketType t WHERE t.ticket IS NOT NULL")
    List<TicketType> findWithTickets();
}
