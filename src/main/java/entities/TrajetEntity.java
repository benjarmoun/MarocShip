package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "trajet", schema = "maroc_ship", catalog = "")
public class TrajetEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "depart")
    private String depart;
    @Basic
    @Column(name = "arrive")
    private String arrive;
    @Basic
    @Column(name = "distance")
    private String distance;
    @Basic
    @Column(name = "zone")
    private String zone;
    @OneToMany(mappedBy = "trajetByTrajetId")
    private Collection<LivraisonEntity> livraisonsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrajetEntity that = (TrajetEntity) o;

        if (id != that.id) return false;
        if (depart != null ? !depart.equals(that.depart) : that.depart != null) return false;
        if (arrive != null ? !arrive.equals(that.arrive) : that.arrive != null) return false;
        if (distance != null ? !distance.equals(that.distance) : that.distance != null) return false;
        if (zone != null ? !zone.equals(that.zone) : that.zone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (depart != null ? depart.hashCode() : 0);
        result = 31 * result + (arrive != null ? arrive.hashCode() : 0);
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (zone != null ? zone.hashCode() : 0);
        return result;
    }

    public Collection<LivraisonEntity> getLivraisonsById() {
        return livraisonsById;
    }

    public void setLivraisonsById(Collection<LivraisonEntity> livraisonsById) {
        this.livraisonsById = livraisonsById;
    }
}
