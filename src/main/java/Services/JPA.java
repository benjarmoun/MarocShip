package Services;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.function.Consumer;

public class JPA {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction tr;

    static {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        tr = em.getTransaction();
    }

    public static void serv(Consumer<EntityManager> action){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            action.accept(em);
            tr.commit();
            em.close();
            em = emf.createEntityManager();
        }catch (RuntimeException re){
            tr.rollback();
            throw re;
        }
    }

    public static EntityManagerFactory entityManagerFactory() {
        return emf;
    }

    public static EntityManager entityManager() {
        em.close();
        em = emf.createEntityManager();
        return em;
    }
    public static EntityTransaction entityTransaction(){ return tr;}

}

