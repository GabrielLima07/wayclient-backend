package com.pi4.wayclient.repository;

import com.pi4.wayclient.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
