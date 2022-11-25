package DAO;

import Services.JPA;
import entities.LivraisonEntity;
import jakarta.persistence.Query;

import java.sql.SQLException;
import java.util.List;

public class LivraisonDAO implements DAO<LivraisonEntity> {

    public static boolean UpdateLivraisonStatusById(String newStatus, int id) {
        try {
            JPA.serv(em ->
                    em.createQuery("update LivraisonEntity  SET status = ?1 where id = ?2 ")
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
    public LivraisonEntity get(long id) {
        LivraisonEntity livraison = JPA.entityManager().find(LivraisonEntity.class, id);
        return livraison;
    }

    @Override
    public List<LivraisonEntity> getAll() {
        Query query = JPA.entityManager().createQuery("SELECT c from LivraisonEntity c");
        return query.getResultList();
    }

    @Override
    public void save(LivraisonEntity livraison) {
        JPA.serv(em -> em.persist(livraison));
    }

    @Override
    public void update(LivraisonEntity livraison) {

    }

    @Override
    public void delete(long id) throws SQLException {
        LivraisonEntity livraison = JPA.entityManager().find(LivraisonEntity.class, id);
        JPA.serv(em -> em.remove(livraison));
    }
}
