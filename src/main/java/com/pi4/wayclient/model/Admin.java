package com.pi4.wayclient.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Admin extends User{
    //TODO: replace String for Department
    @Column
    private List<String> Departments;
    //TODO: replace String for Activity
    @Column
    private List<String> Activities;
}
