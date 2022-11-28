package entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "livraison", schema = "maroc_ship", catalog = "")
public class LivraisonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "chauffeur_id")
    private Integer chauffeurId;
    @Basic
    @Column(name = "trajet_id")
    private int trajetId;
    @Basic
    @Column(name = "poid")
    private double poid;
    @Basic
    @Column(name = "prix")
    private double prix;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "chauffeur_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private ChauffeurEntity chauffeurByChauffeurId;
    @ManyToOne
    @JoinColumn(name = "trajet_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private TrajetEntity trajetByTrajetId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getChauffeurId() {
        return chauffeurId;
    }

    public void setChauffeurId(Integer chauffeurId) {
        this.chauffeurId = chauffeurId;
    }

    public int getTrajetId() {
        return trajetId;
    }

    public void setTrajetId(int trajetId) {
        this.trajetId = trajetId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LivraisonEntity that = (LivraisonEntity) o;

        if (id != that.id) return false;
        if (chauffeurId != that.chauffeurId) return false;
        if (trajetId != that.trajetId) return false;
        if (Double.compare(that.poid, poid) != 0) return false;
        if (Double.compare(that.prix, prix) != 0) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + chauffeurId;
        result = 31 * result + trajetId;
        temp = Double.doubleToLongBits(poid);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public ChauffeurEntity getChauffeurByChauffeurId() {
        return chauffeurByChauffeurId;
    }

    public void setChauffeurByChauffeurId(ChauffeurEntity chauffeurByChauffeurId) {
        this.chauffeurByChauffeurId = chauffeurByChauffeurId;
    }

    public TrajetEntity getTrajetByTrajetId() {
        return trajetByTrajetId;
    }

    public void setTrajetByTrajetId(TrajetEntity trajetByTrajetId) {
        this.trajetByTrajetId = trajetByTrajetId;
    }
}
