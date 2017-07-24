package com.fgvmonserv.model.userauth;


import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ievgenii.tsybaiev on 05.01.2017.
 */

@Entity
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;

    @Column(name = "contactPhoneNumber")
    private String contactPhoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="role")
    @NotFound(action = NotFoundAction.IGNORE)
    private UserRoles userRoles;

    @Column(name = "createdtime", updatable = false)
    @GeneratedValue
    private Date createdtime;
    @Column(name = "updatedtime")
    @GeneratedValue
    private Date updatedtime;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public User setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public User setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public User setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public User setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
        return this;
    }

    public Date getUpdatedtime() {
        return updatedtime;
    }

    public User setUpdatedtime(Date updatedtime) {
        this.updatedtime = updatedtime;
        return this;
    }

    //This method is called during export to CSV. So need to be very carefully to do not export pass etc.
    @Override
    public String toString() {
        return firstName +
                " " + lastName;
    }
}

