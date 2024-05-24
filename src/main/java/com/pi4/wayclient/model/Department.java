package com.pi4.wayclient.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "departament")
    private List<Employee> employees;

    @OneToMany(mappedBy = "departament")
    private List<Admin> admins;

    @OneToOne(mappedBy = "departament", cascade = CascadeType.ALL)
    private Ticket_type tickets_type;

}
