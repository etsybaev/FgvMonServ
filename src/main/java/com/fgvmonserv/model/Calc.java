package com.fgvmonserv.model;

//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fgvmonserv.converter.FlexibleDoubleDeserializer;

public class Calc {
//    @JsonDeserialize(using = FlexibleDoubleDeserializer.class)
    private Double startPrice;
    private Integer auctionStep;
    private Double auctionStepUAH;
    private Integer stockExchangeCommission;
    private Double stockExchangeCommissionUAH;
//    @JsonDeserialize(using = FlexibleDoubleDeserializer.class)
    private Double notaryCommission;
//    @JsonDeserialize(using = FlexibleDoubleDeserializer.class)
    private Double ourCommission;
    private Double finalPrice;

    public Double getStartPrice() {
        return startPrice;
    }

    public Calc setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
        return this;
    }

    public Integer getAuctionStep() {
        return auctionStep;
    }

    public Calc setAuctionStep(Integer auctionStep) {
        this.auctionStep = auctionStep;
        return this;
    }

    public Double getAuctionStepUAH() {
        return auctionStepUAH;
    }

    public Calc setAuctionStepUAH(Double auctionStepUAH) {
        this.auctionStepUAH = auctionStepUAH;
        return this;
    }

    public Integer getStockExchangeCommission() {
        return stockExchangeCommission;
    }

    public Calc setStockExchangeCommission(Integer stockExchangeCommission) {
        this.stockExchangeCommission = stockExchangeCommission;
        return this;
    }

    public Double getStockExchangeCommissionUAH() {
        return stockExchangeCommissionUAH;
    }

    public Calc setStockExchangeCommissionUAH(Double stockExchangeCommissionUAH) {
        this.stockExchangeCommissionUAH = stockExchangeCommissionUAH;
        return this;
    }

    public Double getNotaryCommission() {
        return notaryCommission;
    }

    public Calc setNotaryCommission(Double notaryCommission) {
        this.notaryCommission = notaryCommission;
        return this;
    }

    public Double getOurCommission() {
        return ourCommission;
    }

    public Calc setOurCommission(Double ourCommission) {
        this.ourCommission = ourCommission;
        return this;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public Calc setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calc calc = (Calc) o;

        if (startPrice != null ? !startPrice.equals(calc.startPrice) : calc.startPrice != null) return false;
        if (auctionStep != null ? !auctionStep.equals(calc.auctionStep) : calc.auctionStep != null) return false;
        if (auctionStepUAH != null ? !auctionStepUAH.equals(calc.auctionStepUAH) : calc.auctionStepUAH != null)
            return false;
        if (stockExchangeCommission != null ? !stockExchangeCommission.equals(calc.stockExchangeCommission) : calc.stockExchangeCommission != null)
            return false;
        if (stockExchangeCommissionUAH != null ? !stockExchangeCommissionUAH.equals(calc.stockExchangeCommissionUAH) : calc.stockExchangeCommissionUAH != null)
            return false;
        if (notaryCommission != null ? !notaryCommission.equals(calc.notaryCommission) : calc.notaryCommission != null)
            return false;
        if (ourCommission != null ? !ourCommission.equals(calc.ourCommission) : calc.ourCommission != null)
            return false;
        return finalPrice != null ? finalPrice.equals(calc.finalPrice) : calc.finalPrice == null;
    }

    @Override
    public int hashCode() {
        int result = startPrice != null ? startPrice.hashCode() : 0;
        result = 31 * result + (auctionStep != null ? auctionStep.hashCode() : 0);
        result = 31 * result + (auctionStepUAH != null ? auctionStepUAH.hashCode() : 0);
        result = 31 * result + (stockExchangeCommission != null ? stockExchangeCommission.hashCode() : 0);
        result = 31 * result + (stockExchangeCommissionUAH != null ? stockExchangeCommissionUAH.hashCode() : 0);
        result = 31 * result + (notaryCommission != null ? notaryCommission.hashCode() : 0);
        result = 31 * result + (ourCommission != null ? ourCommission.hashCode() : 0);
        result = 31 * result + (finalPrice != null ? finalPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Calc{" +
                "startPrice=" + startPrice +
                ", auctionStep=" + auctionStep +
                ", auctionStepUAH=" + auctionStepUAH +
                ", stockExchangeCommission=" + stockExchangeCommission +
                ", stockExchangeCommissionUAH=" + stockExchangeCommissionUAH +
                ", notaryCommission=" + notaryCommission +
                ", ourCommission=" + ourCommission +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
