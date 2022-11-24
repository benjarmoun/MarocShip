package Controllers;

import Beans.LivraisonBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named
@RequestScoped
public class LivraisonController {
    @Inject
    LivraisonBean livraisonBean;

    public void addLivraison(){

        System.out.println(livraisonBean.getPoid());

    }

}
