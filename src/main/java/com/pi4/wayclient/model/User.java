package com.pi4.wayclient.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
}
