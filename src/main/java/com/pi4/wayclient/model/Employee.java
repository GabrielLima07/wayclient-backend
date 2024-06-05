package com.pi4.wayclient.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Employee extends UserEntity {
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    @Column
    private String role;

}