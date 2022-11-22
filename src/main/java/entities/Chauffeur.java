package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class Chauffeur extends User {

    @Column(name = "type_vehicule")
    private String typeVehicule;

    public String getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public Chauffeur() {
    }

    public Chauffeur(String userName, String email, String password, String typeVehicule) {
        super(userName, email, password);
        this.typeVehicule = typeVehicule;
    }

    public Chauffeur(int id, String userName, String email, String password, String typeVehicule) {
        super(id, userName, email, password);
        this.typeVehicule = typeVehicule;
    }
}
