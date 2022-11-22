package com.maroc_ship;

import DAO.ChauffeurDAO;
import DAO.StaffDAO;
import entities.Chauffeur;
import entities.Staff;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();

        StaffDAO.getAllStaff();

//        StaffDAO.addStaff(new Staff("hamid","hamid@staff.com","pw","staff"));

        ChauffeurDAO.addChauffeur(new Chauffeur());
    }

}
