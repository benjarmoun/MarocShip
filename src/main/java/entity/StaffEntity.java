package entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;

public class StaffEntity extends UserEntity{
    @Basic
    @Column(name = "role")
    private String role;

    public StaffEntity() {
    }

    public StaffEntity(int id, Integer userName, String email, String password, String role) {
        super(id, userName, email, password);
        this.role = role;
    }
}
