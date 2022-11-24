package Controllers;

import Beans.LivraisonBean;
import DAO.LivraisonDAO;
import Services.Enum;
import entities.Livraison;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.sql.Date;
import java.time.LocalDate;


public class LivraisonController {

    public static boolean addLivraison(double poid, double prix, int trajet){
        Livraison livraison = new Livraison();
        livraison.setStatus(String.valueOf(Enum.statusVal.en_attente));
        livraison.setPoid(poid);
        livraison.setPrix(prix);
        livraison.setTrajet_id(trajet);


        LivraisonDAO livraisonDAO = new LivraisonDAO();
        livraisonDAO.save(livraison);
        return true;
    }

}
