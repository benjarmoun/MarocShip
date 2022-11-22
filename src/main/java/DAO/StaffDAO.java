package DAO;

import Services.JPA;
import entities.Staff;
import jakarta.persistence.Query;

import java.util.List;

public class StaffDAO {
    public static void addStaff(Staff staff) {
        JPA.serv(em -> em.persist(staff));
    }

    public static List<Staff> getAllStaff() {
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

}
