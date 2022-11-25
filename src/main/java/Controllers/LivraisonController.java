package Controllers;

import Beans.LivraisonBean;
import DAO.TrajetDAO;
import entities.Trajet;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;


@Named
@RequestScoped
public class LivraisonController {
    @Inject
    LivraisonBean livraisonBean;
    @Inject
    TrajetDAO trajet ;




    public void addLivraison(){

        System.out.println(livraisonBean.getPoid());

    }

    public LivraisonBean getLivraisonBean() {
        return livraisonBean;
    }

    public void setLivraisonBean(LivraisonBean livraisonBean) {
        this.livraisonBean = livraisonBean;
    }

  


}
