package com.pi4.wayclient.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Admin extends UserEntity{
    @ManyToMany
    @JoinTable(
            name = "admin_department",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private List<Department> departments;

}
