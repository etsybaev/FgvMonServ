package com.fgvmonserv.model;


/**
 * Created by ievgenii.tsybaiev on 05.01.2017.
 */


public class BaseTableImportCheckboxes {

    private boolean isId;
    private boolean isBank;
    private boolean isAuctionDate;
    private boolean isLotNumber;
    private boolean isKdNumber;
    private boolean isAboutAuction;
    private boolean isStartPrice;
    private boolean isUrl;
    private boolean isPropertyDetails;
    private boolean isLoanDebtorFullName;
    private boolean isLoanDebtorPhoneNumber;
    private boolean isLoanDebtorIdentCode;
    private boolean isDetails;
    private boolean isDdateOfCall;
    private boolean isStatusOfCall;
    private boolean isNewPrice;
    private boolean isNewAuctionDate;
    private boolean isAuctionNumber;
    private boolean isSymptom;


    public boolean isId() {
        return isId;
    }

    public BaseTableImportCheckboxes setId(boolean id) {
        isId = id;
        return this;
    }

    public boolean isBank() {
        return isBank;
    }

    public BaseTableImportCheckboxes setBank(boolean bank) {
        isBank = bank;
        return this;
    }

    public boolean isAuctionDate() {
        return isAuctionDate;
    }

    public BaseTableImportCheckboxes setAuctionDate(boolean auctionDate) {
        isAuctionDate = auctionDate;
        return this;
    }

    public boolean isLotNumber() {
        return isLotNumber;
    }

    public BaseTableImportCheckboxes setLotNumber(boolean lotNumber) {
        isLotNumber = lotNumber;
        return this;
    }

    public boolean isKdNumber() {
        return isKdNumber;
    }

    public BaseTableImportCheckboxes setKdNumber(boolean kdNumber) {
        isKdNumber = kdNumber;
        return this;
    }

    public boolean isAboutAuction() {
        return isAboutAuction;
    }

    public BaseTableImportCheckboxes setAboutAuction(boolean aboutAuction) {
        isAboutAuction = aboutAuction;
        return this;
    }

    public boolean isStartPrice() {
        return isStartPrice;
    }

    public BaseTableImportCheckboxes setStartPrice(boolean startPrice) {
        isStartPrice = startPrice;
        return this;
    }

    public boolean isUrl() {
        return isUrl;
    }

    public BaseTableImportCheckboxes setUrl(boolean url) {
        isUrl = url;
        return this;
    }

    public boolean isPropertyDetails() {
        return isPropertyDetails;
    }

    public BaseTableImportCheckboxes setPropertyDetails(boolean propertyDetails) {
        isPropertyDetails = propertyDetails;
        return this;
    }

    public boolean isLoanDebtorFullName() {
        return isLoanDebtorFullName;
    }

    public BaseTableImportCheckboxes setLoanDebtorFullName(boolean loanDebtorFullName) {
        isLoanDebtorFullName = loanDebtorFullName;
        return this;
    }

    public boolean isLoanDebtorPhoneNumber() {
        return isLoanDebtorPhoneNumber;
    }

    public BaseTableImportCheckboxes setLoanDebtorPhoneNumber(boolean loanDebtorPhoneNumber) {
        isLoanDebtorPhoneNumber = loanDebtorPhoneNumber;
        return this;
    }

    public boolean isLoanDebtorIdentCode() {
        return isLoanDebtorIdentCode;
    }

    public BaseTableImportCheckboxes setLoanDebtorIdentCode(boolean loanDebtorIdentCode) {
        isLoanDebtorIdentCode = loanDebtorIdentCode;
        return this;
    }

    public boolean isDetails() {
        return isDetails;
    }

    public BaseTableImportCheckboxes setDetails(boolean details) {
        isDetails = details;
        return this;
    }

    public boolean isDdateOfCall() {
        return isDdateOfCall;
    }

    public BaseTableImportCheckboxes setDdateOfCall(boolean ddateOfCall) {
        isDdateOfCall = ddateOfCall;
        return this;
    }

    public boolean isStatusOfCall() {
        return isStatusOfCall;
    }

    public BaseTableImportCheckboxes setStatusOfCall(boolean statusOfCall) {
        isStatusOfCall = statusOfCall;
        return this;
    }

    public boolean isNewPrice() {
        return isNewPrice;
    }

    public BaseTableImportCheckboxes setNewPrice(boolean newPrice) {
        isNewPrice = newPrice;
        return this;
    }

    public boolean isNewAuctionDate() {
        return isNewAuctionDate;
    }

    public BaseTableImportCheckboxes setNewAuctionDate(boolean newAuctionDate) {
        isNewAuctionDate = newAuctionDate;
        return this;
    }

    public boolean isAuctionNumber() {
        return isAuctionNumber;
    }

    public BaseTableImportCheckboxes setAuctionNumber(boolean auctionNumber) {
        isAuctionNumber = auctionNumber;
        return this;
    }

    public boolean isSymptom() {
        return isSymptom;
    }

    public BaseTableImportCheckboxes setSymptom(boolean symptom) {
        isSymptom = symptom;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseTableImportCheckboxes that = (BaseTableImportCheckboxes) o;

        if (isId != that.isId) return false;
        if (isBank != that.isBank) return false;
        if (isAuctionDate != that.isAuctionDate) return false;
        if (isLotNumber != that.isLotNumber) return false;
        if (isKdNumber != that.isKdNumber) return false;
        if (isAboutAuction != that.isAboutAuction) return false;
        if (isStartPrice != that.isStartPrice) return false;
        if (isUrl != that.isUrl) return false;
        if (isPropertyDetails != that.isPropertyDetails) return false;
        if (isLoanDebtorFullName != that.isLoanDebtorFullName) return false;
        if (isLoanDebtorPhoneNumber != that.isLoanDebtorPhoneNumber) return false;
        if (isLoanDebtorIdentCode != that.isLoanDebtorIdentCode) return false;
        if (isDetails != that.isDetails) return false;
        if (isDdateOfCall != that.isDdateOfCall) return false;
        if (isStatusOfCall != that.isStatusOfCall) return false;
        if (isNewPrice != that.isNewPrice) return false;
        if (isNewAuctionDate != that.isNewAuctionDate) return false;
        if (isAuctionNumber != that.isAuctionNumber) return false;
        return isSymptom == that.isSymptom;
    }

    @Override
    public int hashCode() {
        int result = (isId ? 1 : 0);
        result = 31 * result + (isBank ? 1 : 0);
        result = 31 * result + (isAuctionDate ? 1 : 0);
        result = 31 * result + (isLotNumber ? 1 : 0);
        result = 31 * result + (isKdNumber ? 1 : 0);
        result = 31 * result + (isAboutAuction ? 1 : 0);
        result = 31 * result + (isStartPrice ? 1 : 0);
        result = 31 * result + (isUrl ? 1 : 0);
        result = 31 * result + (isPropertyDetails ? 1 : 0);
        result = 31 * result + (isLoanDebtorFullName ? 1 : 0);
        result = 31 * result + (isLoanDebtorPhoneNumber ? 1 : 0);
        result = 31 * result + (isLoanDebtorIdentCode ? 1 : 0);
        result = 31 * result + (isDetails ? 1 : 0);
        result = 31 * result + (isDdateOfCall ? 1 : 0);
        result = 31 * result + (isStatusOfCall ? 1 : 0);
        result = 31 * result + (isNewPrice ? 1 : 0);
        result = 31 * result + (isNewAuctionDate ? 1 : 0);
        result = 31 * result + (isAuctionNumber ? 1 : 0);
        result = 31 * result + (isSymptom ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseTableImportCheckboxes{" +
                "isId=" + isId +
                ", isBank=" + isBank +
                ", isAuctionDate=" + isAuctionDate +
                ", isLotNumber=" + isLotNumber +
                ", isKdNumber=" + isKdNumber +
                ", isAboutAuction=" + isAboutAuction +
                ", isStartPrice=" + isStartPrice +
                ", isUrl=" + isUrl +
                ", isPropertyDetails=" + isPropertyDetails +
                ", isLoanDebtorFullName=" + isLoanDebtorFullName +
                ", isLoanDebtorPhoneNumber=" + isLoanDebtorPhoneNumber +
                ", isLoanDebtorIdentCode=" + isLoanDebtorIdentCode +
                ", isDetails=" + isDetails +
                ", isDdateOfCall=" + isDdateOfCall +
                ", isStatusOfCall=" + isStatusOfCall +
                ", isNewPrice=" + isNewPrice +
                ", isNewAuctionDate=" + isNewAuctionDate +
                ", isAuctionNumber=" + isAuctionNumber +
                ", isSymptom=" + isSymptom +
                '}';
    }
}

