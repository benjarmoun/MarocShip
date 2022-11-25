package Controllers;


import DAO.LivraisonDAO;
import Services.Enum;
import entities.Livraison;
import jakarta.annotation.PostConstruct;

import java.sql.Date;
import java.time.LocalDate;


public class LivraisonController {

    @PostConstruct
    public void initialize(){
        this.vehicleCategories = vehicleCatDao.getAll();
        this.deliveries = deliveryDao.getAll();
    }

    public static boolean addLivraison(double poid, double prix, Integer idCh, int trajet){
        Livraison livraison = new Livraison();
        livraison.setStatus(String.valueOf(Enum.statusVal.en_attente));
        livraison.setPoid(poid);
        livraison.setPrix(prix);
        livraison.setTrajet_id(trajet);
        livraison.setDate(Date.valueOf(LocalDate.now()));
        livraison.setChauffeur_id(idCh);


        LivraisonDAO livraisonDAO = new LivraisonDAO();
        livraisonDAO.save(livraison);
        return true;
    }

    public static boolean LivraisonStatusDelivre(int id){
        if ( LivraisonDAO.UpdateLivraisonStatusById(String.valueOf(Enum.statusVal.delivré), id)){
            return true;
        }
        return false;
    }

    public static boolean LivraisonStatusEncour(int id){
        if ( LivraisonDAO.UpdateLivraisonStatusById(String.valueOf(Enum.statusVal.en_attente), id)){
            return true;
        }
        return false;
    }


}
