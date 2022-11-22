package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;


@Entity
public class Staff extends User {

    @Column(name = "role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Staff() {
    }

    public Staff( String userName, String email, String password, String role) {
        super(userName, email, password);
        this.role = role;
    }

    public Staff(int id, String userName, String email, String password, String role) {
        super(id, userName, email, password);
        this.role = role;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "role='" + role + '\'' +
                '}';
    }
}
