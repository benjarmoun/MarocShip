package Controllers;


import Beans.LivraisonBean;
import DAO.LivraisonDAO;
import DAO.TrajetDAO;
import Services.Enum;
import entities.LivraisonEntity;
import entities.TrajetEntity;
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

    @Inject
    LivraisonBean livraisonBean;


    private List<TrajetEntity> trajets;

    @PostConstruct
    public void initialize(){
        this.trajets = trajetDao.getAll();
        System.out.println(trajetDao.getAll().size());
    }

    public List<TrajetEntity> getTrajets() {
        return trajets;
    }


    public void addLivraison(){

        LivraisonEntity livraison = new LivraisonEntity();

        livraison.setDate(Date.valueOf(LocalDate.now()));

        livraison.setStatus(String.valueOf(Enum.statusVal.en_attente));

        livraison.setPoid(livraisonBean.getPoid());

        livraison.setPrix(livraisonBean.getPrix());

        livraison.setTrajetId(livraisonBean.getTrajetId());

        LivraisonDAO livraisonDAO = new LivraisonDAO();

        livraisonDAO.save(livraison);


    }
    public void checkPoid(double poid){



    }



//   public static boolean LivraisonStatusDelivre(int id){
//       if ( LivraisonDAO.UpdateLivraisonStatusById(String.valueOf(Enum.statusVal.delivré), id)){
//           return true;
//       }
//       return false;
//   }

//   public static boolean LivraisonStatusEncour(int id){
//       if ( LivraisonDAO.UpdateLivraisonStatusById(String.valueOf(Enum.statusVal.en_attente), id)){
//           return true;
//       }
//       return false;
//   }


}
