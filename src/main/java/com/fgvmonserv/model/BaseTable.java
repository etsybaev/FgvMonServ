package com.fgvmonserv.model;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fgvmonserv.converter.DateTimeConverter;
import com.fgvmonserv.converter.JsonDateDeserializer;
import com.fgvmonserv.converter.JsonDateSerializer;
import com.fgvmonserv.model.userauth.User;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;


/**
 * Created by ievgenii.tsybaiev on 05.01.2017.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "bank",
        "auctionDate",
        "lotNumber",
        "kdNumber",
        "aboutAuction",
        "startPrice",
        "url",
        "propertyDetails",
        "loanDebtorFullName",
        "loanDebtorPhoneNumber",
        "loanDebtorIdentCode",
        "details",
        "dateOfCall",
        "statusOfCall",
        "newPrice",
        "newAuctionDate",
        "auctionNumber",
        "symptom",
        "isUnderControl",
        "statusOfDeal"
})


@Entity
public class BaseTable {

    @JsonProperty("id")
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("bank")
    @Column(name = "bank")
    private String bank;

    //    @OneToOne(fetch=FetchType.EAGER)
//    @JoinColumn(name="role")
//    @NotFound(action = NotFoundAction.IGNORE)
//    private UserRoles userRoles;

    @JsonProperty("auctionDate")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "auctionDate")
    private LocalDate auctionDate;

    @JsonProperty("lotNumber")
    @Column(name = "lotNumber")
    private String lotNumber;

    @JsonProperty("kdNumber")
    @Column(name = "kdNumber")
    private String kdNumber;

    @JsonProperty("aboutAuction")
    @Column(name = "aboutAuction")
    private String aboutAuction;

    @JsonProperty("startPrice")
    @Column(name = "startPrice")
    private String startPrice;

    @JsonProperty("url")
    @Column(name = "url")
    private String url;

    @JsonProperty("propertyDetails")
    @Column(name = "propertyDetails")
    private String propertyDetails;

    @JsonProperty("loanDebtorFullName")
    @Column(name = "loanDebtorFullName")
    private String loanDebtorFullName;

    @JsonProperty("loanDebtorPhoneNumber")
    @Column(name = "loanDebtorPhoneNumber")
    private String loanDebtorPhoneNumber;

    @JsonProperty("loanDebtorIdentCode")
    @Column(name = "loanDebtorIdentCode")
    private String loanDebtorIdentCode;

    @JsonProperty("details")
    @Column(name = "details")
    private String details;

    @JsonProperty("dateOfCall")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "dateOfCall")
    private LocalDate dateOfCall;

    @JsonProperty("statusOfCall")
    @Column(name = "statusOfCall")
    private String statusOfCall;

    @JsonProperty("newPrice")
    @Column(name = "newPrice")
    private String newPrice;

    @JsonProperty("newAuctionDate")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "newAuctionDate")
    private LocalDate newAuctionDate;

    @JsonProperty("auctionNumber")
    @Column(name = "auctionNumber")
    private String auctionNumber;

    @JsonProperty("symptom")
    @Column(name = "symptom")
    private String symptom;

    @JsonProperty("isUnderControl")
    @Column(name = "isUnderControl")
    private boolean isUnderControl;

    @JsonProperty("manager")
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="manager")
    @NotFound(action = NotFoundAction.IGNORE)
    private User manager;

    @JsonProperty("statusOfDeal")
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="statusOfDeal")
    @NotFound(action = NotFoundAction.IGNORE)
    private StatusOfDeal statusOfDeal;


    @JsonIgnore
    public static BaseTable getShortBaseTableFromCsvLine(String[] lineFromCsv){
        return new BaseTable()
                .setBank(lineFromCsv[1])
                .setAuctionDate(DateTimeConverter.parseLocalDate(lineFromCsv[2]))
                .setLotNumber(lineFromCsv[3])
                .setKdNumber(lineFromCsv[4])
                .setAboutAuction(lineFromCsv[5])
                .setStartPrice(lineFromCsv[6])
                .setUrl(lineFromCsv[7])
                .setPropertyDetails(lineFromCsv[8]);
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public BaseTable setId(Integer id) {
        this.id = id;
        return this;
    }

    @JsonProperty("bank")
    public String getBank() {
        return bank;
    }

    @JsonProperty("bank")
    public BaseTable setBank(String bank) {
        this.bank = bank;
        return this;
    }

    @JsonProperty("auctionDate")
    public LocalDate getAuctionDate() {
        return auctionDate;
    }

    @JsonProperty("auctionDate")
    public BaseTable setAuctionDate(LocalDate auctionDate) {
        this.auctionDate = auctionDate;
        return this;
    }

    @JsonProperty("lotNumber")
    public String getLotNumber() {
        return lotNumber;
    }

    @JsonProperty("lotNumber")
    public BaseTable setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
        return this;
    }

    @JsonProperty("kdNumber")
    public String getKdNumber() {
        return kdNumber;
    }

    @JsonProperty("kdNumber")
    public BaseTable setKdNumber(String kdNumber) {
        this.kdNumber = kdNumber;
        return this;
    }

    @JsonProperty("aboutAuction")
    public String getAboutAuction() {
        return aboutAuction;
    }

    @JsonProperty("aboutAuction")
    public BaseTable setAboutAuction(String aboutAuction) {
        this.aboutAuction = aboutAuction;
        return this;
    }

    @JsonProperty("startPrice")
    public String getStartPrice() {
        return startPrice;
    }

    @JsonProperty("startPrice")
    public BaseTable setStartPrice(String startPrice) {
        this.startPrice = startPrice;
        return this;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public BaseTable setUrl(String url) {
        this.url = url;
        return this;
    }

    @JsonProperty("propertyDetails")
    public String getPropertyDetails() {
        return propertyDetails;
    }

    @JsonProperty("propertyDetails")
    public BaseTable setPropertyDetails(String propertyDetails) {
        this.propertyDetails = propertyDetails;
        return this;
    }

    @JsonProperty("loanDebtorFullName")
    public String getLoanDebtorFullName() {
        return loanDebtorFullName;
    }

    @JsonProperty("loanDebtorFullName")
    public BaseTable setLoanDebtorFullName(String loanDebtorFullName) {
        this.loanDebtorFullName = loanDebtorFullName;
        return this;
    }

    @JsonProperty("loanDebtorPhoneNumber")
    public String getLoanDebtorPhoneNumber() {
        return loanDebtorPhoneNumber;
    }

    @JsonProperty("loanDebtorPhoneNumber")
    public BaseTable setLoanDebtorPhoneNumber(String loanDebtorPhoneNumber) {
        this.loanDebtorPhoneNumber = loanDebtorPhoneNumber;
        return this;
    }

    @JsonProperty("loanDebtorIdentCode")
    public String getLoanDebtorIdentCode() {
        return loanDebtorIdentCode;
    }

    @JsonProperty("loanDebtorIdentCode")
    public BaseTable setLoanDebtorIdentCode(String loanDebtorIdentCode) {
        this.loanDebtorIdentCode = loanDebtorIdentCode;
        return this;
    }

    @JsonProperty("details")
    public String getDetails() {
        return details;
    }

    @JsonProperty("details")
    public BaseTable setDetails(String details) {
        this.details = details;
        return this;
    }

    @JsonProperty("dateOfCall")
    public LocalDate getDateOfCall() {
        return dateOfCall;
    }

    @JsonProperty("dateOfCall")
    public BaseTable setDateOfCall(LocalDate dateOfCall) {
        this.dateOfCall = dateOfCall;
        return this;
    }

    @JsonProperty("statusOfCall")
    public String getStatusOfCall() {
        return statusOfCall;
    }

    @JsonProperty("statusOfCall")
    public BaseTable setStatusOfCall(String statusOfCall) {
        this.statusOfCall = statusOfCall;
        return this;
    }

    @JsonProperty("newPrice")
    public String getNewPrice() {
        return newPrice;
    }

    @JsonProperty("newPrice")
    public BaseTable setNewPrice(String newPrice) {
        this.newPrice = newPrice;
        return this;
    }

    @JsonProperty("newAuctionDate")
    public LocalDate getNewAuctionDate() {
        return newAuctionDate;
    }

    @JsonProperty("newAuctionDate")
    public BaseTable setNewAuctionDate(LocalDate newAuctionDate) {
        this.newAuctionDate = newAuctionDate;
        return this;
    }

    @JsonProperty("auctionNumber")
    public String getAuctionNumber() {
        return auctionNumber;
    }

    @JsonProperty("auctionNumber")
    public BaseTable setAuctionNumber(String auctionNumber) {
        this.auctionNumber = auctionNumber;
        return this;
    }

    @JsonProperty("symptom")
    public String getSymptom() {
        return symptom;
    }

    @JsonProperty("symptom")
    public BaseTable setSymptom(String symptom) {
        this.symptom = symptom;
        return this;
    }

    @JsonProperty("isUnderControl")
    public boolean getIsUnderControl() {
        return isUnderControl;
    }

    @JsonProperty("isUnderControl")
    public BaseTable setIsUnderControl(boolean isUnderControl) {
        this.isUnderControl = isUnderControl;
        return this;
    }

    @JsonProperty("manager")
    public User getManager() {
        return manager;
    }

    @JsonProperty("manager")
    public BaseTable setManager(User manager) {
        this.manager = manager;
        return this;
    }

    @JsonProperty("statusOfDeal")
    public StatusOfDeal getStatusOfDeal() {
        return statusOfDeal;
    }

    @JsonProperty("statusOfDeal")
    public BaseTable setStatusOfDeal(StatusOfDeal statusOfDeal) {
        this.statusOfDeal = statusOfDeal;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseTable baseTable = (BaseTable) o;

        if (isUnderControl != baseTable.isUnderControl) return false;
        if (id != null ? !id.equals(baseTable.id) : baseTable.id != null) return false;
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
        if (symptom != null ? !symptom.equals(baseTable.symptom) : baseTable.symptom != null) return false;
        if (manager != null ? !manager.equals(baseTable.manager) : baseTable.manager != null) return false;
        return statusOfDeal != null ? statusOfDeal.equals(baseTable.statusOfDeal) : baseTable.statusOfDeal == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
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
        result = 31 * result + (isUnderControl ? 1 : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (statusOfDeal != null ? statusOfDeal.hashCode() : 0);
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
                ", isUnderControl=" + isUnderControl +
                ", manager=" + manager +
                ", statusOfDeal=" + statusOfDeal +
                '}';
    }
}

