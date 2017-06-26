package com.fgvmonserv.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sun.istack.internal.Nullable;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;


/**
 * Created by ievgenii.tsybaiev on 05.01.2017.
 */

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//        "id",
//        "startPrice",
//        "",
//        "",
//        "",
//        "",
//        ""
//})


@Entity
public class CalculatorPageTable {

//    @JsonProperty("id")
    @Id
    @Column(name = "id")
//    @ColumnDefault("0")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "auctionStep")
    private Double auctionStep;
    @Column(name = "stockExchangeCommission")
    private Double stockExchangeCommission;
    @Column(name = "notaryCommission")
    private Double notaryCommission;
    @Column(name = "ourCommission")
    private Double ourCommission;
    @Column(name = "finalPrice")
    private Double finalPrice;

    public CalculatorPageTable(){}

    public CalculatorPageTable(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public CalculatorPageTable setId(Integer id) {
        this.id = id;
        return this;
    }


    public Double getAuctionStep() {
        return auctionStep;
    }

    public CalculatorPageTable setAuctionStep(Double auctionStep) {
        this.auctionStep = auctionStep;
        return this;
    }

    public Double getStockExchangeCommission() {
        return stockExchangeCommission;
    }

    public CalculatorPageTable setStockExchangeCommission(Double stockExchangeCommission) {
        this.stockExchangeCommission = stockExchangeCommission;
        return this;
    }

    public Double getNotaryCommission() {
        return notaryCommission;
    }

    public CalculatorPageTable setNotaryCommission(Double notaryCommission) {
        this.notaryCommission = notaryCommission;
        return this;
    }

    public Double getOurCommission() {
        return ourCommission;
    }

    public CalculatorPageTable setOurCommission(Double ourCommission) {
        this.ourCommission = ourCommission;
        return this;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public CalculatorPageTable setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
        return this;
    }


    //This method is call during export to CSV, so we keep value only
    @Override
    public String toString() {
        return "CalculatorPageTable{" +
                "finalPrice=" + finalPrice +
                '}';
    }
}

