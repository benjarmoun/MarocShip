package Beans;


import Controllers.LivraisonController;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;


import Controllers.LivraisonController;

import java.sql.Date;

@Named
@RequestScoped
public class LivraisonBean {
    public int getTrajet_id() {
        return trajet_id;
    }

    public void setTrajet_id(int trajet_id) {
        this.trajet_id = trajet_id;
    }



    private double prix;
    private double poid;
    private Date date;

    private int trajet_id;




    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getPoid() {
        return poid;
    }

    public void setPoid(double poid) {
        this.poid = poid;
    }

    public void addLivraison(){
        LivraisonController.addLivraison( poid,prix,trajet_id);
    }
}
