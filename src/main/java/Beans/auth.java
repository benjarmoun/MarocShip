package Beans;


import entities.ChauffeurEntity;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;


@Named
@SessionScoped
public class auth implements Serializable {

    ChauffeurEntity chauffeur = new ChauffeurEntity();

    private static String role;
    private static String typeVehicule;

    private static Integer chauffeurId;

    public static Integer getChauffeurId() {
        return chauffeurId;
    }

    public static void setChauffeurId(Integer chauffeurId) {
        auth.chauffeurId = chauffeurId;
    }

    public static String getTypeVehicule() {
        return typeVehicule;
    }

    public static void setTypeVehicule(String typeVehicule) {
        auth.typeVehicule = typeVehicule;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        auth.role = role;
    }
}
