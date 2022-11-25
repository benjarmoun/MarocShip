package DAO;

import Services.JPA;
import entities.Staff;
import entities.Trajet;
import jakarta.persistence.Query;

import java.sql.SQLException;
import java.util.List;

public class TrajetDAO implements DAO<Trajet> {
    @Override
    public Trajet get(long id) {
        return null;
    }

    @Override
    public List<Trajet> getAll() {

        Query query = JPA.entityManager().createQuery("SELECT t from Trajet t");

        return query.getResultList();
    }

    @Override
    public void save(Trajet trajet) {

    }

    @Override
    public void update(Trajet trajet) {

    }

    @Override
    public void delete(long id) throws SQLException {

    }
}
