package Controllers;


import DAO.LivraisonDAO;
import DAO.TrajetDAO;
import Services.Enum;
import entities.Livraison;
import entities.Trajet;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Named
@RequestScoped
public class LivraisonController {

    TrajetDAO trajetDao = new TrajetDAO();


    private List<Trajet> trajets;

    @PostConstruct
    public void initialize(){

        this.trajets = trajetDao.getAll();
        System.out.println(trajetDao.getAll().size());
    }

    public List<Trajet> getTrajets() {
        return trajets;
    }

    public static boolean addLivraison(double poid, Double prix,int trajet){
        Livraison livraison = new Livraison();
        livraison.setStatus(String.valueOf(Enum.statusVal.en_attente));
        livraison.setPoid(poid);
        livraison.setPrix(prix);
        livraison.setTrajet_id(trajet);

        livraison.setDate(Date.valueOf(LocalDate.now()));
//        livraison.setChauffeur_id(idCh);


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
