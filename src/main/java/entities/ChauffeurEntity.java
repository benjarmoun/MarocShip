package entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "chauffeur", schema = "maroc_ship", catalog = "")
public class ChauffeurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "typevehicule")
    private String typevehicule;
    @OneToMany(mappedBy = "chauffeurByChauffeurId")
    private Collection<LivraisonEntity> livraisonsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypevehicule() {
        return typevehicule;
    }

    public void setTypevehicule(String typevehicule) {
        this.typevehicule = typevehicule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChauffeurEntity that = (ChauffeurEntity) o;

        if (id != that.id) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (typevehicule != null ? !typevehicule.equals(that.typevehicule) : that.typevehicule != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (typevehicule != null ? typevehicule.hashCode() : 0);
        return result;
    }

    public Collection<LivraisonEntity> getLivraisonsById() {
        return livraisonsById;
    }

    public void setLivraisonsById(Collection<LivraisonEntity> livraisonsById) {
        this.livraisonsById = livraisonsById;
    }
}
