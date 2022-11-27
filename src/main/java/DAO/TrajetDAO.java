package DAO;

import Services.JPA;
import entities.StaffEntity;
import entities.TrajetEntity;
import jakarta.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class TrajetDAO implements DAO<TrajetEntity> {
    @Override
    public TrajetEntity get(long id) {
        return null;
    }

    @Override
    public List<TrajetEntity> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT t from TrajetEntity t");
        return query.getResultList();
    }

    @Override
    public void save(TrajetEntity trajet) {

    }

    @Override
    public void update(TrajetEntity trajet) {

    }

    @Override
    public void delete(long id) throws SQLException {

    }
}
