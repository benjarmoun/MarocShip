package Controllers;

import DAO.ChauffeurDAO;
import DAO.StaffDAO;
import entities.ChauffeurEntity;
import entities.StaffEntity;

import java.util.List;
import java.util.stream.Collectors;

import static Services.Hash.MD5;

public class StaffController {

    public static StaffEntity login(String email, String pw, String role) throws Exception {
        StaffDAO staffDao = new StaffDAO();
        List<StaffEntity> lst = staffDao.getAll().stream()
                .filter(staff -> staff.getEmail().equals(email))
                .filter(staff -> staff.getRole().equals(role))
                .collect(Collectors.toList());
        if(lst.size()!= 0 && lst.get(0).getPassword().equals((pw))){
            return lst.get(0);
        }else{
            return null;
        }
    }
    public static ChauffeurEntity loginChauffeur(String email, String pw) throws Exception {
        ChauffeurDAO chauffeurDAO = new ChauffeurDAO();
        List<ChauffeurEntity> lst = chauffeurDAO.getAll().stream()
                .filter(staff -> staff.getEmail().equals(email))
                .collect(Collectors.toList());
        if(lst.size()!= 0 && lst.get(0).getPassword().equals((pw))){
            return lst.get(0);
        }else{
            return null;
        }
    }
}
