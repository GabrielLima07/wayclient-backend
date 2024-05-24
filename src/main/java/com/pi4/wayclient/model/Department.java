package com.pi4.wayclient.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    @ManyToMany(mappedBy = "departments")
    private List<Admin> admins;

    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    private Ticket_type ticket_type;

}
