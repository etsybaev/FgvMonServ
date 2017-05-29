package com.fgvmonserv.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by ievgenii.tsybaiev on 05.01.2017.
 */

@Entity
public class BaseTable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bank")
    private String bank;

    //    @OneToOne(fetch=FetchType.EAGER)
//    @JoinColumn(name="role")
//    @NotFound(action = NotFoundAction.IGNORE)
//    private UserRoles userRoles;

    @Column(name = "auctionDate")
    @GeneratedValue
    private Date auctionDate;

    @Column(name = "lotNumber")
    private String lotNumber;

    @Column(name = "adminComments")
    private String adminComments;


    public int getId() {
        return id;
    }

    public BaseTable setId(int id) {
        this.id = id;
        return this;
    }

    public String getBank() {
        return bank;
    }

    public BaseTable setBank(String bank) {
        this.bank = bank;
        return this;
    }

    public Date getAuctionDate() {
        return auctionDate;
    }

    public BaseTable setAuctionDate(Date auctionDate) {
        this.auctionDate = auctionDate;
        return this;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public BaseTable setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
        return this;
    }

    public String getAdminComments() {
        return adminComments;
    }

    public BaseTable setAdminComments(String adminComments) {
        this.adminComments = adminComments;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseTable baseTable = (BaseTable) o;

        if (id != baseTable.id) return false;
        if (bank != null ? !bank.equals(baseTable.bank) : baseTable.bank != null) return false;
        if (auctionDate != null ? !auctionDate.equals(baseTable.auctionDate) : baseTable.auctionDate != null)
            return false;
        if (lotNumber != null ? !lotNumber.equals(baseTable.lotNumber) : baseTable.lotNumber != null) return false;
        return adminComments != null ? adminComments.equals(baseTable.adminComments) : baseTable.adminComments == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        result = 31 * result + (auctionDate != null ? auctionDate.hashCode() : 0);
        result = 31 * result + (lotNumber != null ? lotNumber.hashCode() : 0);
        result = 31 * result + (adminComments != null ? adminComments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseTable{" +
                "id=" + id +
                ", bank='" + bank + '\'' +
                ", auctionDate=" + auctionDate +
                ", lotNumber='" + lotNumber + '\'' +
                ", adminComments='" + adminComments + '\'' +
                '}';
    }
}

