package com.pi4.wayclient.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Admin extends User{
    @ManyToMany
    @JoinTable(
            name = "admin_department",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private List<Department> departments;

    //TODO: replace String for Activity when coded
    //TODO: replace column for relationship when Activity gets coded
    @Column
    private List<String> activities;
}
