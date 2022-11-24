package Beans;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.Date;

@Named
@RequestScoped
public class LivraisonBean {

    private String prix;
    private double poid;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public double getPoid() {
        return poid;
    }

    public void setPoid(double poid) {
        this.poid = poid;
    }
}
