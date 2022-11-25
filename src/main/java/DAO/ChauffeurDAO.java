package DAO;

import Services.JPA;
import entities.ChauffeurEntity;
import jakarta.persistence.Query;

import java.sql.SQLException;
import java.util.List;

public class ChauffeurDAO implements DAO <ChauffeurEntity>{


    @Override
    public ChauffeurEntity get(long id) {
        ChauffeurEntity chauffeur = JPA.entityManager().find(ChauffeurEntity.class, id);
        return chauffeur;
    }

    @Override
    public List<ChauffeurEntity> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT c from ChauffeurEntity c");
        return query.getResultList();
    }

    @Override
    public void save(ChauffeurEntity chauffeur) {
        JPA.serv(em -> em.persist(chauffeur));
    }

    @Override
    public void update(ChauffeurEntity chauffeur) {

    }

    @Override
    public void delete(long id) throws SQLException {
        ChauffeurEntity chauffeur = JPA.entityManager().find(ChauffeurEntity.class, id);
        JPA.serv(em -> em.remove(chauffeur));
    }
}
 