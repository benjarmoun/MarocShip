package DAO;

import Services.JPA;
import entities.Livraison;
import entities.Livraison;
import jakarta.persistence.Query;

import java.sql.SQLException;
import java.util.List;

public class LivraisonDAO implements DAO<Livraison> {

    public static boolean UpdateLivraisonStatusById(String newStatus, int id) {
        try {
            JPA.serv(em ->
                    em.createQuery("update Livraison  SET status = ?1 where id = ?2 ")
                            .setParameter(1, newStatus)
                            .setParameter(2, id)
                            .executeUpdate()
            );
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Livraison get(long id) {
        Livraison livraison = JPA.entityManager().find(Livraison.class, id);
        return livraison;
    }

    @Override
    public List<Livraison> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT c from Livraison c");
        return query.getResultList();
    }

    @Override
    public void save(Livraison livraison) {
        JPA.serv(em -> em.persist(livraison));
    }

    @Override
    public void update(Livraison livraison) {

    }

    @Override
    public void delete(long id) throws SQLException {
        Livraison livraison = JPA.entityManager().find(Livraison.class, id);
        JPA.serv(em -> em.remove(livraison));
    }
}
