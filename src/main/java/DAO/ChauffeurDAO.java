package DAO;

import Services.JPA;
import entities.Chauffeur;
import entities.Staff;
import jakarta.persistence.Query;

import java.util.List;

public class ChauffeurDAO {
    public static void addChauffeur(Chauffeur chauffeur) {
        JPA.serv(em -> em.persist(chauffeur));
    }

    public static List<Chauffeur> getAllChauffeur() {
        Query query = JPA.entityManager().createQuery("SELECT c from Chauffeur c");
        return query.getResultList();
    }
}
