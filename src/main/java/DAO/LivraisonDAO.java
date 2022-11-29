package DAO;

import Services.JPA;
import entities.LivraisonEntity;
import jakarta.persistence.Query;

import java.sql.SQLException;
import java.util.List;

public class LivraisonDAO implements DAO<LivraisonEntity> {

    public static boolean UpdateLivraisonStatusById(String newStatus, int id,int idChe) {
        try {
            JPA.serv(em ->
                    em.createQuery("update LivraisonEntity  SET status = ?1 , chauffeurId=?2 where id = ?3 ")
                            .setParameter(1, newStatus)
                            .setParameter(2, idChe)
                            .setParameter(3, id)
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
    public List<LivraisonEntity> getVoiture() {
        Query query = JPA.entityManager().createQuery("SELECT c from LivraisonEntity c where c.status =?1 AND c.poid<=200  ").setParameter(1,"en_attente");
        return query.getResultList();
    }
    public List<LivraisonEntity> getCamion() {
        Query query = JPA.entityManager().createQuery("SELECT c from LivraisonEntity c where c.status =?1 AND c.poid <=800 ").setParameter(1,"en_attente");
        return query.getResultList();
    }
    public List<LivraisonEntity> getGCamion() {
        Query query = JPA.entityManager().createQuery("SELECT c from LivraisonEntity c where c.status =?1 AND c.poid <=1600 ").setParameter(1,"en_attente");
        return query.getResultList();
    }

    @Override
    public void save(LivraisonEntity livraison) {
        JPA.serv(em -> em.persist(livraison));
    }

    @Override
    public void update(LivraisonEntity livraison) {
        JPA.serv(em -> em.merge(livraison));
    }

    @Override
    public void delete(long id) throws SQLException {
        LivraisonEntity livraison = JPA.entityManager().find(LivraisonEntity.class, id);
        JPA.serv(em -> em.remove(livraison));
    }
}
