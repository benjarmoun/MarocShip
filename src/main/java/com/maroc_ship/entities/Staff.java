package com.maroc_ship.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class Staff extends User {

    @Column(name = "role")
    private String role;

    public Staff() {
    }

    public Staff(int id, Integer userName, String email, String password, String role) {
        super(id, userName, email, password);
        this.role = role;
    }
}
