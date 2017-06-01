package com.fgvmonserv.model;


import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Created by ievgenii.tsybaiev on 05.01.2017.
 */

@Entity
public class BaseTable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bank")
    private String bank;

    //    @OneToOne(fetch=FetchType.EAGER)
//    @JoinColumn(name="role")
//    @NotFound(action = NotFoundAction.IGNORE)
//    private UserRoles userRoles;

    @DateTimeFormat(pattern="dd.MM.yyyy")
    @Column(name = "auctionDate")
    private LocalDate auctionDate;
    @Column(name = "lotNumber")
    private String lotNumber;
    @Column(name = "kdNumber")
    private String kdNumber;
    @Column(name = "aboutAuction")
    private String aboutAuction;
    @Column(name = "startPrice")
    private String startPrice;
    @Column(name = "url")
    private String url;
    @Column(name = "propertyDetails")
    private String propertyDetails;
    @Column(name = "loanDebtorFullName")
    private String loanDebtorFullName;
    @Column(name = "loanDebtorPhoneNumber")
    private String loanDebtorPhoneNumber;
    @Column(name = "loanDebtorIdentCode")
    private String loanDebtorIdentCode;
    @Column(name = "details")
    private String details;
    @DateTimeFormat(pattern="dd.MM.yyyy")
    @Column(name = "dateOfCall")
    private LocalDate dateOfCall;
    @Column(name = "statusOfCall")
    private String statusOfCall;
    @Column(name = "newPrice")
    private String newPrice;
    @DateTimeFormat(pattern="dd.MM.yyyy")
    @Column(name = "newAuctionDate")
    private LocalDate newAuctionDate;
    @Column(name = "auctionNumber")
    private String auctionNumber;
    @Column(name = "symptom")
    private String symptom;

    public static BaseTable getShortBaseTableFromCsvLine(String[] lineFromCsv){
        return new BaseTable()
                .setBank(lineFromCsv[1])
                .setAuctionDate(LocalDate.parse(lineFromCsv[2], DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .setLotNumber(lineFromCsv[3])
                .setKdNumber(lineFromCsv[4])
                .setAboutAuction(lineFromCsv[5])
                .setStartPrice(lineFromCsv[6])
                .setUrl(lineFromCsv[7])
                .setPropertyDetails(lineFromCsv[8]);
    }

    //I know this is harcode. Will re0write it later
    public String[] getValuesAsStringArray(){
        String[] objectAsArray = new String[19];
        objectAsArray[0] = getId().toString() ;
        objectAsArray[1] = getBank();
        objectAsArray[2] = getAuctionDate() == null ? "-" : getAuctionDate().toString();
        objectAsArray[3] = getLotNumber();
        objectAsArray[4] = getKdNumber();
        objectAsArray[5] = getAboutAuction();
        objectAsArray[6] = getStartPrice();
        objectAsArray[7] = getUrl();
        objectAsArray[8] = getPropertyDetails();
        objectAsArray[9] = getLoanDebtorFullName();
        objectAsArray[10] = getLoanDebtorPhoneNumber();
        objectAsArray[11] = getLoanDebtorIdentCode();
        objectAsArray[12] = getDetails();
        objectAsArray[13] = getDateOfCall() == null ? "-" : getDateOfCall().toString();
        objectAsArray[14] = getStatusOfCall();
        objectAsArray[15] = getNewPrice();
        objectAsArray[16] = getNewAuctionDate() == null ? "-" : getNewAuctionDate().toString();
        objectAsArray[17] = getAuctionNumber();
        objectAsArray[18] = getSymptom();
        return objectAsArray;
    }

    public Integer getId() {
        return id;
    }

    public BaseTable setId(Integer id) {
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

    public LocalDate getAuctionDate() {
        return auctionDate;
    }

    public BaseTable setAuctionDate(LocalDate auctionDate) {
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

    public String getKdNumber() {
        return kdNumber;
    }

    public BaseTable setKdNumber(String kdNumber) {
        this.kdNumber = kdNumber;
        return this;
    }

    public String getAboutAuction() {
        return aboutAuction;
    }

    public BaseTable setAboutAuction(String aboutAuction) {
        this.aboutAuction = aboutAuction;
        return this;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public BaseTable setStartPrice(String startPrice) {
        this.startPrice = startPrice;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public BaseTable setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPropertyDetails() {
        return propertyDetails;
    }

    public BaseTable setPropertyDetails(String propertyDetails) {
        this.propertyDetails = propertyDetails;
        return this;
    }

    public String getLoanDebtorFullName() {
        return loanDebtorFullName;
    }

    public BaseTable setLoanDebtorFullName(String loanDebtorFullName) {
        this.loanDebtorFullName = loanDebtorFullName;
        return this;
    }

    public String getLoanDebtorPhoneNumber() {
        return loanDebtorPhoneNumber;
    }

    public BaseTable setLoanDebtorPhoneNumber(String loanDebtorPhoneNumber) {
        this.loanDebtorPhoneNumber = loanDebtorPhoneNumber;
        return this;
    }

    public String getLoanDebtorIdentCode() {
        return loanDebtorIdentCode;
    }

    public BaseTable setLoanDebtorIdentCode(String loanDebtorIdentCode) {
        this.loanDebtorIdentCode = loanDebtorIdentCode;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public BaseTable setDetails(String details) {
        this.details = details;
        return this;
    }

    public LocalDate getDateOfCall() {
        return dateOfCall;
    }

    public BaseTable setDateOfCall(LocalDate dateOfCall) {
        this.dateOfCall = dateOfCall;
        return this;
    }

    public String getStatusOfCall() {
        return statusOfCall;
    }

    public BaseTable setStatusOfCall(String statusOfCall) {
        this.statusOfCall = statusOfCall;
        return this;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public BaseTable setNewPrice(String newPrice) {
        this.newPrice = newPrice;
        return this;
    }

    public LocalDate getNewAuctionDate() {
        return newAuctionDate;
    }

    public BaseTable setNewAuctionDate(LocalDate newAuctionDate) {
        this.newAuctionDate = newAuctionDate;
        return this;
    }

    public String getAuctionNumber() {
        return auctionNumber;
    }

    public BaseTable setAuctionNumber(String auctionNumber) {
        this.auctionNumber = auctionNumber;
        return this;
    }

    public String getSymptom() {
        return symptom;
    }

    public BaseTable setSymptom(String symptom) {
        this.symptom = symptom;
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
        if (kdNumber != null ? !kdNumber.equals(baseTable.kdNumber) : baseTable.kdNumber != null) return false;
        if (aboutAuction != null ? !aboutAuction.equals(baseTable.aboutAuction) : baseTable.aboutAuction != null)
            return false;
        if (startPrice != null ? !startPrice.equals(baseTable.startPrice) : baseTable.startPrice != null) return false;
        if (url != null ? !url.equals(baseTable.url) : baseTable.url != null) return false;
        if (propertyDetails != null ? !propertyDetails.equals(baseTable.propertyDetails) : baseTable.propertyDetails != null)
            return false;
        if (loanDebtorFullName != null ? !loanDebtorFullName.equals(baseTable.loanDebtorFullName) : baseTable.loanDebtorFullName != null)
            return false;
        if (loanDebtorPhoneNumber != null ? !loanDebtorPhoneNumber.equals(baseTable.loanDebtorPhoneNumber) : baseTable.loanDebtorPhoneNumber != null)
            return false;
        if (loanDebtorIdentCode != null ? !loanDebtorIdentCode.equals(baseTable.loanDebtorIdentCode) : baseTable.loanDebtorIdentCode != null)
            return false;
        if (details != null ? !details.equals(baseTable.details) : baseTable.details != null) return false;
        if (dateOfCall != null ? !dateOfCall.equals(baseTable.dateOfCall) : baseTable.dateOfCall != null) return false;
        if (statusOfCall != null ? !statusOfCall.equals(baseTable.statusOfCall) : baseTable.statusOfCall != null)
            return false;
        if (newPrice != null ? !newPrice.equals(baseTable.newPrice) : baseTable.newPrice != null) return false;
        if (newAuctionDate != null ? !newAuctionDate.equals(baseTable.newAuctionDate) : baseTable.newAuctionDate != null)
            return false;
        if (auctionNumber != null ? !auctionNumber.equals(baseTable.auctionNumber) : baseTable.auctionNumber != null)
            return false;
        return symptom != null ? symptom.equals(baseTable.symptom) : baseTable.symptom == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        result = 31 * result + (auctionDate != null ? auctionDate.hashCode() : 0);
        result = 31 * result + (lotNumber != null ? lotNumber.hashCode() : 0);
        result = 31 * result + (kdNumber != null ? kdNumber.hashCode() : 0);
        result = 31 * result + (aboutAuction != null ? aboutAuction.hashCode() : 0);
        result = 31 * result + (startPrice != null ? startPrice.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (propertyDetails != null ? propertyDetails.hashCode() : 0);
        result = 31 * result + (loanDebtorFullName != null ? loanDebtorFullName.hashCode() : 0);
        result = 31 * result + (loanDebtorPhoneNumber != null ? loanDebtorPhoneNumber.hashCode() : 0);
        result = 31 * result + (loanDebtorIdentCode != null ? loanDebtorIdentCode.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (dateOfCall != null ? dateOfCall.hashCode() : 0);
        result = 31 * result + (statusOfCall != null ? statusOfCall.hashCode() : 0);
        result = 31 * result + (newPrice != null ? newPrice.hashCode() : 0);
        result = 31 * result + (newAuctionDate != null ? newAuctionDate.hashCode() : 0);
        result = 31 * result + (auctionNumber != null ? auctionNumber.hashCode() : 0);
        result = 31 * result + (symptom != null ? symptom.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseTable{" +
                "id=" + id +
                ", bank='" + bank + '\'' +
                ", auctionDate=" + auctionDate +
                ", lotNumber='" + lotNumber + '\'' +
                ", kdNumber='" + kdNumber + '\'' +
                ", aboutAuction='" + aboutAuction + '\'' +
                ", startPrice='" + startPrice + '\'' +
                ", url='" + url + '\'' +
                ", propertyDetails='" + propertyDetails + '\'' +
                ", loanDebtorFullName='" + loanDebtorFullName + '\'' +
                ", loanDebtorPhoneNumber='" + loanDebtorPhoneNumber + '\'' +
                ", loanDebtorIdentCode='" + loanDebtorIdentCode + '\'' +
                ", details='" + details + '\'' +
                ", dateOfCall=" + dateOfCall +
                ", statusOfCall='" + statusOfCall + '\'' +
                ", newPrice='" + newPrice + '\'' +
                ", newAuctionDate=" + newAuctionDate +
                ", auctionNumber='" + auctionNumber + '\'' +
                ", symptom='" + symptom + '\'' +
                '}';
    }
}

