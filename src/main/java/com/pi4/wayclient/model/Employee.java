package com.pi4.wayclient.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Employee extends User {
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    //TODO: replace String for Activity when coded
    //TODO: replace column for relationship when Activity gets coded
    @Column
    private List<String> activities;

    @Column
    private String role;
}