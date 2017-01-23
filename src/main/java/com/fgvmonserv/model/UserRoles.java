package com.fgvmonserv.model;

import javax.persistence.*;

/**
 * Created by ievgenii.tsybaiev on 12.01.2017.
 */

@Entity
public class UserRoles {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role")
    private String role;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "UserRoles{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
