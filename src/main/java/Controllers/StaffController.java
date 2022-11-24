package Controllers;

import DAO.StaffDAO;
import entities.Staff;

import java.util.List;
import java.util.stream.Collectors;

import static Services.Hash.MD5;

public class StaffController {

    public static Staff login(String email, String pw, String role) throws Exception {
        StaffDAO staffDao = new StaffDAO();
        List<Staff> lst = staffDao.getAll().stream()
                .filter(staff -> staff.getEmail().equals(email))
                .filter(staff -> staff.getRole().equals(role))
                .collect(Collectors.toList());

        if(lst.size()!= 0 && lst.get(0).getPassword().equals((pw))){
            return lst.get(0);
        }else
            return null;
    }
}
