package com.maroc_ship;

import Controllers.LivraisonController;
import Controllers.StaffController;
import DAO.ChauffeurDAO;
import DAO.StaffDAO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Null;

public class Main {
    public static void main(String[] args) throws Exception {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();

//
        StaffController.login("email","pw","staff");

//        LivraisonController.addLivraison(20,130, null,1);


    }

}
