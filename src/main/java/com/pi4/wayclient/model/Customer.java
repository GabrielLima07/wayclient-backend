package com.pi4.wayclient.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Customer extends User {

    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

}
