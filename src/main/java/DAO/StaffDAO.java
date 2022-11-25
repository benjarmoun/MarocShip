package DAO;

import Services.JPA;

import entities.StaffEntity;
import jakarta.persistence.Query;

import java.sql.SQLException;
import java.util.List;

public class StaffDAO implements DAO<StaffEntity>{

    @Override
    public StaffEntity get(long id) {
        StaffEntity staff = JPA.entityManager().find(StaffEntity.class, id);
        return staff;
    }

    @Override
    public List<StaffEntity> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT s from StaffEntity s");
        List<StaffEntity> lst = query.getResultList();
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i).getUsername());
            System.out.println(lst.get(i).getEmail());
            System.out.println(lst.get(i).getPassword());
            System.out.println(lst.get(i).getRole());
        }

        return query.getResultList();
    }

    @Override
    public void save(StaffEntity staff) {
        JPA.serv(em -> em.persist(staff));
    }

    @Override
    public void update(StaffEntity staff) {

    }

    @Override
    public void delete(long id) throws SQLException {
        StaffEntity staff = JPA.entityManager().find(StaffEntity.class, id);
        JPA.serv(em -> em.remove(staff));
    }
}
