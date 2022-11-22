package entities;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
public class Livraison {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "poid")
    private double poid;

    @Column(name = "prix")
    private double prix;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;


    @Column(name = "trajet_id")
    private int trajet_id;

    @Column(name = "chauffeur_id")
    private int chauffeur_id;
    @ManyToOne
    @JoinColumn(name = "chauffeur_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Chauffeur chauffeurByChauffeurId;

    @ManyToOne
    @JoinColumn(name = "trajet_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Trajet trajetByTrajetId;

    public int getTrajet_id() {
        return trajet_id;
    }

    public void setTrajet_id(int trajet_id) {
        this.trajet_id = trajet_id;
    }

    public int getChauffeur_id() {
        return chauffeur_id;
    }

    public void setChauffeur_id(int chauffeur_id) {
        this.chauffeur_id = chauffeur_id;
    }

    public Chauffeur getChauffeurByChauffeurId() {
        return chauffeurByChauffeurId;
    }

    public void setChauffeurByChauffeurId(Chauffeur chauffeurByChauffeurId) {
        this.chauffeurByChauffeurId = chauffeurByChauffeurId;
    }

    public Trajet getTrajetByTrajetId() {
        return trajetByTrajetId;
    }

    public void setTrajetByTrajetId(Trajet trajetByTrajetId) {
        this.trajetByTrajetId = trajetByTrajetId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPoid() {
        return poid;
    }

    public void setPoid(double poid) {
        this.poid = poid;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
