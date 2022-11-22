package com.maroc_ship.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class Chauffeur extends User {

    @Column(name = "type_vehicule")
    private String typeVehicule;

    public Chauffeur() {
    }

    public Chauffeur(int id, Integer userName, String email, String password, String typeVehicule) {
        super(id, userName, email, password);
        this.typeVehicule = typeVehicule;
    }
}
