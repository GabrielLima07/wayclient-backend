package com.pi4.wayclient.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import com.pi4.wayclient.model.Department;
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
}
