package DAO;

import Services.JPA;
import entities.Staff;
import jakarta.persistence.Query;

import java.sql.SQLException;
import java.util.List;

public class StaffDAO implements DAO<Staff>{

    @Override
    public Staff get(long id) {

        Staff staff = JPA.entityManager().find(Staff.class, id);
        return staff;
    }

    @Override
    public List<Staff> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT s from Staff s");

        List<Staff> lst = query.getResultList();
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(lst.get(i).getUserName());
            System.out.println(lst.get(i).getEmail());
            System.out.println(lst.get(i).getPassword());
            System.out.println(lst.get(i).getRole());
        }

        return query.getResultList();
    }

    @Override
    public void save(Staff staff) {
        JPA.serv(em -> em.persist(staff));
    }

    @Override
    public void update(Staff staff) {

    }

    @Override
    public void delete(long id) throws SQLException {

    }
}
