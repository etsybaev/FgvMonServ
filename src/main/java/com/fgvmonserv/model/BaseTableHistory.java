package com.fgvmonserv.model;


import com.fgvmonserv.model.userauth.User;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class BaseTableHistory{


    //@JsonProperty("id")
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@JsonProperty("bank")
    @Column(name = "bank")
    private String bank;

    //    @OneToOne(fetch=FetchType.EAGER)
//    @JoinColumn(name="role")
//    @NotFound(action = NotFoundAction.IGNORE)
//    private UserRoles userRoles;

    //@JsonProperty("auctionDate")
    //@JsonDeserialize(using = JsonDateDeserializer.class)
    //@JsonSerialize(using = JsonDateSerializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "auctionDate")
    private LocalDate auctionDate;

    //@JsonProperty("lotNumber")
    @Column(name = "lotNumber")
    private String lotNumber;

    //@JsonProperty("kdNumber")
    @Column(name = "kdNumber")
    private String kdNumber;

    //@JsonProperty("aboutAuction")
    @Column(name = "aboutAuction")
    private String aboutAuction;

    //@JsonProperty("startPrice")
    @Column(name = "startPrice")
    private Double startPrice;

    @Column(name = "auctionStep")
    private Integer auctionStep;

    @Column(name = "stockExchangeCommission")
    private Integer stockExchangeCommission;

    @Column(name = "notaryCommission")
    private Double notaryCommission;

    @Column(name = "ourCommission")
    private Double ourCommission;

    @Column(name = "finalPrice")
    private Integer finalPrice;

    //@JsonProperty("url")
    @Column(name = "url")
    private String url;

    //@JsonProperty("propertyDetails")
    @Column(name = "propertyDetails")
    private String propertyDetails;

    //@JsonProperty("loanDebtorFullName")
    @Column(name = "loanDebtorFullName")
    private String loanDebtorFullName;

    //@JsonProperty("loanDebtorPhoneNumber")
    @Column(name = "loanDebtorPhoneNumber")
    private String loanDebtorPhoneNumber;

    //@JsonProperty("loanDebtorIdentCode")
    @Column(name = "loanDebtorIdentCode")
    private String loanDebtorIdentCode;

    //@JsonProperty("details")
    @Column(name = "details")
    private String details;

    //@JsonProperty("dateOfCall")
    //@JsonDeserialize(using = JsonDateDeserializer.class)
    //@JsonSerialize(using = JsonDateSerializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "dateOfCall")
    private LocalDate dateOfCall;

    //@JsonProperty("statusOfCall")
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="statusOfCall")
    @NotFound(action = NotFoundAction.IGNORE)
    private StatusOfCall statusOfCall;

    //@JsonProperty("newAuctionDate")
    //@JsonDeserialize(using = JsonDateDeserializer.class)
    //@JsonSerialize(using = JsonDateSerializer.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "newAuctionDate")
    private LocalDate newAuctionDate;

    //@JsonProperty("managersComment")
    @Column(name = "managersComment")
    private String managersComment;

    //@JsonProperty("symptom")
    @Column(name = "symptom")
    private String symptom;

    //@JsonProperty("isUnderControl")
    @Column(name = "isUnderControl")
    private boolean isUnderControl;

    //@JsonProperty("manager")
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="manager")
    @NotFound(action = NotFoundAction.IGNORE)
    private User manager;

    //@JsonProperty("statusOfDeal")
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="statusOfDeal")
    @NotFound(action = NotFoundAction.IGNORE)
    private StatusOfDeal statusOfDeal;

    @Column(name = "baseTableRecordId")
    private Integer baseTableRecordId;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="managerUpdatedBy")
    @NotFound(action = NotFoundAction.IGNORE)
    private User managerUpdatedBy;

    @Column(name = "updatedTime", updatable = false)
    @GeneratedValue
    private LocalDateTime updatedTime;


    public BaseTableHistory(){}

    public BaseTableHistory(BaseTable baseTable) {
        this.baseTableRecordId = baseTable.getId();
        this.bank = baseTable.getBank();
        this.auctionDate = baseTable.getAuctionDate();
        this.lotNumber = baseTable.getLotNumber();
        this.kdNumber = baseTable.getKdNumber();
        this.aboutAuction = baseTable.getAboutAuction();
        this.startPrice = baseTable.getStartPrice();
        this.auctionStep = baseTable.getAuctionStep();
        this.stockExchangeCommission = baseTable.getStockExchangeCommission();
        this.notaryCommission = baseTable.getNotaryCommission();
        this.ourCommission = baseTable.getOurCommission();
        this.finalPrice = baseTable.getFinalPrice();
        this.url = baseTable.getUrl();
        this.propertyDetails = baseTable.getPropertyDetails();
        this.loanDebtorFullName = baseTable.getLoanDebtorFullName();
        this.loanDebtorPhoneNumber = baseTable.getLoanDebtorPhoneNumber();
        this.loanDebtorIdentCode = baseTable.getLoanDebtorIdentCode();
        this.details = baseTable.getDetails();
        this.dateOfCall = baseTable.getDateOfCall();
        this.statusOfCall = baseTable.getStatusOfCall();
        this.newAuctionDate = baseTable.getNewAuctionDate();
        this.managersComment = baseTable.getManagersComment();
        this.symptom = baseTable.getSymptom();
        this.isUnderControl = baseTable.getIsUnderControl();
        this.manager = baseTable.getManager();
        this.statusOfDeal = baseTable.getStatusOfDeal();
    }

    public Integer getId() {
        return id;
    }

    public BaseTableHistory setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getBank() {
        return bank;
    }

    public BaseTableHistory setBank(String bank) {
        this.bank = bank;
        return this;
    }

    public LocalDate getAuctionDate() {
        return auctionDate;
    }

    public BaseTableHistory setAuctionDate(LocalDate auctionDate) {
        this.auctionDate = auctionDate;
        return this;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public BaseTableHistory setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
        return this;
    }

    public String getKdNumber() {
        return kdNumber;
    }

    public BaseTableHistory setKdNumber(String kdNumber) {
        this.kdNumber = kdNumber;
        return this;
    }

    public String getAboutAuction() {
        return aboutAuction;
    }

    public BaseTableHistory setAboutAuction(String aboutAuction) {
        this.aboutAuction = aboutAuction;
        return this;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public BaseTableHistory setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
        return this;
    }

    public Integer getAuctionStep() {
        return auctionStep;
    }

    public BaseTableHistory setAuctionStep(Integer auctionStep) {
        this.auctionStep = auctionStep;
        return this;
    }

    public Integer getStockExchangeCommission() {
        return stockExchangeCommission;
    }

    public BaseTableHistory setStockExchangeCommission(Integer stockExchangeCommission) {
        this.stockExchangeCommission = stockExchangeCommission;
        return this;
    }

    public Double getNotaryCommission() {
        return notaryCommission;
    }

    public BaseTableHistory setNotaryCommission(Double notaryCommission) {
        this.notaryCommission = notaryCommission;
        return this;
    }

    public Double getOurCommission() {
        return ourCommission;
    }

    public BaseTableHistory setOurCommission(Double ourCommission) {
        this.ourCommission = ourCommission;
        return this;
    }

    public Integer getFinalPrice() {
        return finalPrice;
    }

    public BaseTableHistory setFinalPrice(Integer finalPrice) {
        this.finalPrice = finalPrice;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public BaseTableHistory setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPropertyDetails() {
        return propertyDetails;
    }

    public BaseTableHistory setPropertyDetails(String propertyDetails) {
        this.propertyDetails = propertyDetails;
        return this;
    }

    public String getLoanDebtorFullName() {
        return loanDebtorFullName;
    }

    public BaseTableHistory setLoanDebtorFullName(String loanDebtorFullName) {
        this.loanDebtorFullName = loanDebtorFullName;
        return this;
    }

    public String getLoanDebtorPhoneNumber() {
        return loanDebtorPhoneNumber;
    }

    public BaseTableHistory setLoanDebtorPhoneNumber(String loanDebtorPhoneNumber) {
        this.loanDebtorPhoneNumber = loanDebtorPhoneNumber;
        return this;
    }

    public String getLoanDebtorIdentCode() {
        return loanDebtorIdentCode;
    }

    public BaseTableHistory setLoanDebtorIdentCode(String loanDebtorIdentCode) {
        this.loanDebtorIdentCode = loanDebtorIdentCode;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public BaseTableHistory setDetails(String details) {
        this.details = details;
        return this;
    }

    public LocalDate getDateOfCall() {
        return dateOfCall;
    }

    public BaseTableHistory setDateOfCall(LocalDate dateOfCall) {
        this.dateOfCall = dateOfCall;
        return this;
    }

    public StatusOfCall getStatusOfCall() {
        return statusOfCall;
    }

    public BaseTableHistory setStatusOfCall(StatusOfCall statusOfCall) {
        this.statusOfCall = statusOfCall;
        return this;
    }

    public LocalDate getNewAuctionDate() {
        return newAuctionDate;
    }

    public BaseTableHistory setNewAuctionDate(LocalDate newAuctionDate) {
        this.newAuctionDate = newAuctionDate;
        return this;
    }

    public String getManagersComment() {
        return managersComment;
    }

    public BaseTableHistory setManagersComment(String managersComment) {
        this.managersComment = managersComment;
        return this;
    }

    public String getSymptom() {
        return symptom;
    }

    public BaseTableHistory setSymptom(String symptom) {
        this.symptom = symptom;
        return this;
    }

    public boolean getIsUnderControl() {
        return isUnderControl;
    }

    public BaseTableHistory setIsUnderControl(boolean isUnderControl) {
        isUnderControl = isUnderControl;
        return this;
    }

    public User getManager() {
        return manager;
    }

    public BaseTableHistory setManager(User manager) {
        this.manager = manager;
        return this;
    }

    public StatusOfDeal getStatusOfDeal() {
        return statusOfDeal;
    }

    public BaseTableHistory setStatusOfDeal(StatusOfDeal statusOfDeal) {
        this.statusOfDeal = statusOfDeal;
        return this;
    }

    public Integer getBaseTableRecordId() {
        return baseTableRecordId;
    }

    public BaseTableHistory setBaseTableRecordId(Integer baseTableRecordId) {
        this.baseTableRecordId = baseTableRecordId;
        return this;
    }

    public User getManagerUpdatedBy() {
        return managerUpdatedBy;
    }

    public BaseTableHistory setManagerUpdatedBy(User managerUpdatedBy) {
        this.managerUpdatedBy = managerUpdatedBy;
        return this;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public BaseTableHistory setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseTableHistory that = (BaseTableHistory) o;

        if (isUnderControl != that.isUnderControl) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (bank != null ? !bank.equals(that.bank) : that.bank != null) return false;
        if (auctionDate != null ? !auctionDate.equals(that.auctionDate) : that.auctionDate != null) return false;
        if (lotNumber != null ? !lotNumber.equals(that.lotNumber) : that.lotNumber != null) return false;
        if (kdNumber != null ? !kdNumber.equals(that.kdNumber) : that.kdNumber != null) return false;
        if (aboutAuction != null ? !aboutAuction.equals(that.aboutAuction) : that.aboutAuction != null) return false;
        if (startPrice != null ? !startPrice.equals(that.startPrice) : that.startPrice != null) return false;
        if (auctionStep != null ? !auctionStep.equals(that.auctionStep) : that.auctionStep != null) return false;
        if (stockExchangeCommission != null ? !stockExchangeCommission.equals(that.stockExchangeCommission) : that.stockExchangeCommission != null)
            return false;
        if (notaryCommission != null ? !notaryCommission.equals(that.notaryCommission) : that.notaryCommission != null)
            return false;
        if (ourCommission != null ? !ourCommission.equals(that.ourCommission) : that.ourCommission != null)
            return false;
        if (finalPrice != null ? !finalPrice.equals(that.finalPrice) : that.finalPrice != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (propertyDetails != null ? !propertyDetails.equals(that.propertyDetails) : that.propertyDetails != null)
            return false;
        if (loanDebtorFullName != null ? !loanDebtorFullName.equals(that.loanDebtorFullName) : that.loanDebtorFullName != null)
            return false;
        if (loanDebtorPhoneNumber != null ? !loanDebtorPhoneNumber.equals(that.loanDebtorPhoneNumber) : that.loanDebtorPhoneNumber != null)
            return false;
        if (loanDebtorIdentCode != null ? !loanDebtorIdentCode.equals(that.loanDebtorIdentCode) : that.loanDebtorIdentCode != null)
            return false;
        if (details != null ? !details.equals(that.details) : that.details != null) return false;
        if (dateOfCall != null ? !dateOfCall.equals(that.dateOfCall) : that.dateOfCall != null) return false;
        if (statusOfCall != null ? !statusOfCall.equals(that.statusOfCall) : that.statusOfCall != null) return false;
        if (newAuctionDate != null ? !newAuctionDate.equals(that.newAuctionDate) : that.newAuctionDate != null)
            return false;
        if (managersComment != null ? !managersComment.equals(that.managersComment) : that.managersComment != null)
            return false;
        if (symptom != null ? !symptom.equals(that.symptom) : that.symptom != null) return false;
        if (manager != null ? !manager.equals(that.manager) : that.manager != null) return false;
        if (statusOfDeal != null ? !statusOfDeal.equals(that.statusOfDeal) : that.statusOfDeal != null) return false;
        if (baseTableRecordId != null ? !baseTableRecordId.equals(that.baseTableRecordId) : that.baseTableRecordId != null)
            return false;
        if (managerUpdatedBy != null ? !managerUpdatedBy.equals(that.managerUpdatedBy) : that.managerUpdatedBy != null)
            return false;
        return updatedTime != null ? updatedTime.equals(that.updatedTime) : that.updatedTime == null;
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
        result = 31 * result + (auctionStep != null ? auctionStep.hashCode() : 0);
        result = 31 * result + (stockExchangeCommission != null ? stockExchangeCommission.hashCode() : 0);
        result = 31 * result + (notaryCommission != null ? notaryCommission.hashCode() : 0);
        result = 31 * result + (ourCommission != null ? ourCommission.hashCode() : 0);
        result = 31 * result + (finalPrice != null ? finalPrice.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (propertyDetails != null ? propertyDetails.hashCode() : 0);
        result = 31 * result + (loanDebtorFullName != null ? loanDebtorFullName.hashCode() : 0);
        result = 31 * result + (loanDebtorPhoneNumber != null ? loanDebtorPhoneNumber.hashCode() : 0);
        result = 31 * result + (loanDebtorIdentCode != null ? loanDebtorIdentCode.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (dateOfCall != null ? dateOfCall.hashCode() : 0);
        result = 31 * result + (statusOfCall != null ? statusOfCall.hashCode() : 0);
        result = 31 * result + (newAuctionDate != null ? newAuctionDate.hashCode() : 0);
        result = 31 * result + (managersComment != null ? managersComment.hashCode() : 0);
        result = 31 * result + (symptom != null ? symptom.hashCode() : 0);
        result = 31 * result + (isUnderControl ? 1 : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (statusOfDeal != null ? statusOfDeal.hashCode() : 0);
        result = 31 * result + (baseTableRecordId != null ? baseTableRecordId.hashCode() : 0);
        result = 31 * result + (managerUpdatedBy != null ? managerUpdatedBy.hashCode() : 0);
        result = 31 * result + (updatedTime != null ? updatedTime.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "BaseTableHistory{" +
                "id=" + id +
                ", bank='" + bank + '\'' +
                ", auctionDate=" + auctionDate +
                ", lotNumber='" + lotNumber + '\'' +
                ", kdNumber='" + kdNumber + '\'' +
                ", aboutAuction='" + aboutAuction + '\'' +
                ", startPrice=" + startPrice +
                ", auctionStep=" + auctionStep +
                ", stockExchangeCommission=" + stockExchangeCommission +
                ", notaryCommission=" + notaryCommission +
                ", ourCommission=" + ourCommission +
                ", finalPrice=" + finalPrice +
                ", url='" + url + '\'' +
                ", propertyDetails='" + propertyDetails + '\'' +
                ", loanDebtorFullName='" + loanDebtorFullName + '\'' +
                ", loanDebtorPhoneNumber='" + loanDebtorPhoneNumber + '\'' +
                ", loanDebtorIdentCode='" + loanDebtorIdentCode + '\'' +
                ", details='" + details + '\'' +
                ", dateOfCall=" + dateOfCall +
                ", statusOfCall=" + statusOfCall +
                ", newAuctionDate=" + newAuctionDate +
                ", managersComment='" + managersComment + '\'' +
                ", symptom='" + symptom + '\'' +
                ", isUnderControl=" + isUnderControl +
                ", manager=" + manager +
                ", statusOfDeal=" + statusOfDeal +
                ", baseTableRecordId=" + baseTableRecordId +
                ", managerUpdatedBy=" + managerUpdatedBy +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
