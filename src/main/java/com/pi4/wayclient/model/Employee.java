package com.pi4.wayclient.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class  Employee extends User{

    @Column
    private List<String> Departments;

    @Column
    private List<String> Activities;

    @Column
    private String role;
}