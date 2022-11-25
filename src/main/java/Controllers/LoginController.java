package Controllers;

import Beans.LoginBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class LoginController {

    @Inject
    LoginBean login;
    public String login(){


        System.out.println("azerty");
        return "Livraison.xhtml?faces-redirect=true";


    }


}
