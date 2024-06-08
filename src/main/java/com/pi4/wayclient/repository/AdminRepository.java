package com.pi4.wayclient.repository;

import com.pi4.wayclient.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
    Optional<Admin> findByEmail(String email);

    List<Admin> findByDepartments_Id(UUID departmentId);

    @Query("SELECT a FROM Admin a WHERE a.name = :name")
    List<Admin> findByName(@Param("name") String name);

    @Query("SELECT a FROM Admin a WHERE a.email LIKE %:domain%")
    List<Admin> findByEmailDomain(@Param("domain") String domain);
}
