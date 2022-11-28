package Controllers;


import Beans.LivraisonBean;
import DAO.ChauffeurDAO;
import DAO.LivraisonDAO;
import DAO.TrajetDAO;
import Beans.auth;
import Services.Enum;
import Services.mail;
import entities.ChauffeurEntity;
import entities.LivraisonEntity;
import entities.TrajetEntity;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Named
@RequestScoped
public class LivraisonController {


    public LivraisonController() {
        auth.setRole("chauffeur");
        auth.setTypeVehicule(String.valueOf(Enum.vehicleType.voiture));
        if(auth.getRole().equals("chauffeur")){
            if(auth.getTypeVehicule().equals(String.valueOf (Enum.vehicleType.voiture))){
                this.livraisons = livraisonDao.getVoiture();

            } else if (auth.getTypeVehicule().equals("camion")) {
                this.livraisons = livraisonDao.getCamion();
            } else if (auth.getTypeVehicule().equals("GCamion")) {
                this.livraisons = livraisonDao.getGCamion();
            }
        }
    }

    TrajetDAO trajetDao = new TrajetDAO();
    LivraisonDAO livraisonDao = new LivraisonDAO();

    @Inject
    LivraisonBean livraisonBean;





    private List<TrajetEntity> trajets;

    public List<LivraisonEntity> getLivraisons() {
        return livraisons;
    }

    public void setLivraisons(List<LivraisonEntity> livraisons) {
        this.livraisons = livraisons;
    }

    private List<LivraisonEntity> livraisons;




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
        ChauffeurDAO chauffeurDAO = new ChauffeurDAO();
        List<ChauffeurEntity>  chauffeurs = new ArrayList<>();

        if(livraison.getPoid()<=200){
            chauffeurs = chauffeurDAO.getAll()
                    .stream()
                    .filter(ch -> ch.getTypevehicule().equals("voiture"))
                    .collect(Collectors.toList());
        } else if (livraison.getPoid()<=800 ) {
            chauffeurs = chauffeurDAO.getAll()
                    .stream()
                    .filter(ch -> ch.getTypevehicule().equals("petit_camion"))
                    .collect(Collectors.toList());
        } else if (livraison.getPoid()<=1600) {
            chauffeurs = chauffeurDAO.getAll()
                    .stream()
                    .filter(ch -> ch.getTypevehicule().equals("grand_camion"))
                    .collect(Collectors.toList());
        }

        chauffeurs.forEach(ch -> mail.send("benjarmoun123@gmail.com", "nouvelle livraison ","Nouvelle livraison disponibles consulter votre compte pour plus de details "));


    }

    public void editLivraison(int id){
        auth.setChauffeurId(1);
        livraisonDao.UpdateLivraisonStatusById(String.valueOf(Enum.statusVal.en_cour),id,auth.getChauffeurId());
    }

    @PostConstruct
    public void initialize(){
        this.trajets = trajetDao.getAll();

    }
}
