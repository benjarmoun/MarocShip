package Beans;


import Controllers.LoginController;
import Controllers.StaffController;
import Services.JPA;
import entities.ChauffeurEntity;
import entities.StaffEntity;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.Query;

import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class LoginBean {
    @Inject
    auth chauffeur;
    private String email;
    private String password;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String loginBean() throws Exception {

        try {
           StaffEntity stf = StaffController.login(this.email,this.password,"chauffeur");

           if(stf != null){

                return "Livraison.xhtml?faces-redirect=true";
            }else{
                return "Login.xhtml?faces-redirect=true";
            }


        }catch (Exception e){
            throw e;
        }
    }

    public String loginBeanChauffeur() throws Exception {

        try {
            ChauffeurEntity stf = StaffController.loginChauffeur(this.email,this.password);

            if(stf != null){
                chauffeur.setTypeVehicule("chaufffeur");
                chauffeur.setRole("chauffeur");
                return "getLivraison.xhtml?faces-redirect=true";
            }else{
                return "LoginChauffeur.xhtml?faces-redirect=true";
            }


        }catch (Exception e){
            throw e;
        }
    }
}
