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

    public void login(){

    }


}
