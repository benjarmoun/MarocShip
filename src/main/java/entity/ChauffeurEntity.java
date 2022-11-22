package entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;

public class ChauffeurEntity extends UserEntity {
    @Basic
    @Column(name = "typeVehicule")
    private String typeVehicule;

    public ChauffeurEntity() {
    }

    public ChauffeurEntity(int id, Integer userName, String email, String password, String typeVehicule) {
        super(id, userName, email, password);
        this.typeVehicule = typeVehicule;
    }
}
