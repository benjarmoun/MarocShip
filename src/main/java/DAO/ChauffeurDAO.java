package DAO;

import Services.JPA;
import entities.Chauffeur;
import jakarta.persistence.Query;

import java.sql.SQLException;
import java.util.List;

public class ChauffeurDAO implements DAO <Chauffeur>{


    @Override
    public Chauffeur get(long id) {
        return null;
    }

    @Override
    public List<Chauffeur> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT c from Chauffeur c");
        return query.getResultList();
    }

    @Override
    public void save(Chauffeur chauffeur) {
        JPA.serv(em -> em.persist(chauffeur));
    }

    @Override
    public void update(Chauffeur chauffeur) {

    }

    @Override
    public void delete(long id) throws SQLException {

    }
}
