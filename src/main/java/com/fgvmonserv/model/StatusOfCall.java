package com.fgvmonserv.model;

import javax.persistence.*;

/**
 * Created by ievgeniit on 13.06.17.
 */

@Entity
public class StatusOfCall {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status")
    private String status;


    public Integer getId() {
        return id;
    }

    public StatusOfCall setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public StatusOfCall setStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusOfCall that = (StatusOfCall) o;

        if (id != that.id) return false;
        return status != null ? status.equals(that.status) : that.status == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    //This toString is calling during export to CSV
    @Override
    public String toString() {
        return status;
    }
}
