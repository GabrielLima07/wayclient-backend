package com.pi4.wayclient.repository;

import com.pi4.wayclient.model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<ServiceEntity, UUID> {
}
