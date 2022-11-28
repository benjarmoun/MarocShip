package Beans;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.Date;

@Named
@RequestScoped
public class LivraisonBean {

    private double prix;
    private double poid;
    private String date;
    private int trajetId;




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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTrajetId() {
        return trajetId;
    }

    public void setTrajetId(int trajetId) {
        this.trajetId = trajetId;
    }
}
