package com.fgvmonserv.dao.htmlobjects_legacy;

import org.jsoup.select.Elements;

/**
 * Created with IntelliJ IDEA.
 * User: Evg
 * Date: 23.01.17
 * Time: 21:41
 * To change this template use File | Settings | File Templates.
 */
public class Passport {

    private String lotsForSale;
    private String numberAndDateOfComitetAboutSalesCondition;
    private String publicAuctionOrganizer;
    private String warrantyPayment;
    private String participantsNumberCondition;
    private String bankInfoForRegistrationPayment;
    private String auctionStepAndAmountRaiseCondition;
    private String procedureForReviewTheProperty;
    private String contactPersonInBankToReviewTheProperty;
    private String auctionDate;
    private String auctionTime;
    private String urlForElectronicAuction;
    private String placeAndFormForThoseWhoWantToTakeAPart;
    private String deadlineForSubmitAnApplicationForAuction;
    private String deadlineForWarrantyPayment;
    private String totalOpenedBiddingLimit;


    public Passport(Elements tbody){
        this.lotsForSale = getTextFromTable(tbody, 0);
        this.numberAndDateOfComitetAboutSalesCondition = getTextFromTable(tbody, 1);
        this.publicAuctionOrganizer = getTextFromTable(tbody, 2);
        this.warrantyPayment = getTextFromTable(tbody, 3);
        this.participantsNumberCondition = getTextFromTable(tbody, 4);
        this.bankInfoForRegistrationPayment = getTextFromTable(tbody, 5);
        this.auctionStepAndAmountRaiseCondition = getTextFromTable(tbody, 6);
        this.procedureForReviewTheProperty = getTextFromTable(tbody, 7);
        this.contactPersonInBankToReviewTheProperty = getTextFromTable(tbody, 8);
        this.auctionDate = getTextFromTable(tbody, 9);
        this.auctionTime = getTextFromTable(tbody, 10);
        this.urlForElectronicAuction = getTextFromTable(tbody, 11);
        this.placeAndFormForThoseWhoWantToTakeAPart = getTextFromTable(tbody, 12);
        this.deadlineForSubmitAnApplicationForAuction = getTextFromTable(tbody, 13);
        this.deadlineForWarrantyPayment = getTextFromTable(tbody, 14);
        this.totalOpenedBiddingLimit = getTextFromTable(tbody, 15);
    }

    private String getTextFromTable(Elements tbody, int index){
        try{
            return tbody.get(index).children().get(1).text();
        } catch (IndexOutOfBoundsException e){
            System.out.println("Something wrong on page");
        }
        return "No data found";
    }

    public String getLotsForSale() {
        return lotsForSale;
    }

    public void setLotsForSale(String lotsForSale) {
        this.lotsForSale = lotsForSale;
    }

    public String getNumberAndDateOfComitetAboutSalesCondition() {
        return numberAndDateOfComitetAboutSalesCondition;
    }

    public void setNumberAndDateOfComitetAboutSalesCondition(String numberAndDateOfComitetAboutSalesCondition) {
        this.numberAndDateOfComitetAboutSalesCondition = numberAndDateOfComitetAboutSalesCondition;
    }

    public String getPublicAuctionOrganizer() {
        return publicAuctionOrganizer;
    }

    public void setPublicAuctionOrganizer(String publicAuctionOrganizer) {
        this.publicAuctionOrganizer = publicAuctionOrganizer;
    }

    public String getWarrantyPayment() {
        return warrantyPayment;
    }

    public void setWarrantyPayment(String warrantyPayment) {
        this.warrantyPayment = warrantyPayment;
    }

    public String getParticipantsNumberCondition() {
        return participantsNumberCondition;
    }

    public void setParticipantsNumberCondition(String participantsNumberCondition) {
        this.participantsNumberCondition = participantsNumberCondition;
    }

    public String getBankInfoForRegistrationPayment() {
        return bankInfoForRegistrationPayment;
    }

    public void setBankInfoForRegistrationPayment(String bankInfoForRegistrationPayment) {
        this.bankInfoForRegistrationPayment = bankInfoForRegistrationPayment;
    }

    public String getAuctionStepAndAmountRaiseCondition() {
        return auctionStepAndAmountRaiseCondition;
    }

    public void setAuctionStepAndAmountRaiseCondition(String auctionStepAndAmountRaiseCondition) {
        this.auctionStepAndAmountRaiseCondition = auctionStepAndAmountRaiseCondition;
    }

    public String getProcedureForReviewTheProperty() {
        return procedureForReviewTheProperty;
    }

    public void setProcedureForReviewTheProperty(String procedureForReviewTheProperty) {
        this.procedureForReviewTheProperty = procedureForReviewTheProperty;
    }

    public String getContactPersonInBankToReviewTheProperty() {
        return contactPersonInBankToReviewTheProperty;
    }

    public void setContactPersonInBankToReviewTheProperty(String contactPersonInBankToReviewTheProperty) {
        this.contactPersonInBankToReviewTheProperty = contactPersonInBankToReviewTheProperty;
    }

    public String getAuctionDate() {
        return auctionDate;
    }

    public void setAuctionDate(String auctionDate) {
        this.auctionDate = auctionDate;
    }

    public String getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(String auctionTime) {
        this.auctionTime = auctionTime;
    }

    public String getUrlForElectronicAuction() {
        return urlForElectronicAuction;
    }

    public void setUrlForElectronicAuction(String urlForElectronicAuction) {
        this.urlForElectronicAuction = urlForElectronicAuction;
    }

    public String getPlaceAndFormForThoseWhoWantToTakeAPart() {
        return placeAndFormForThoseWhoWantToTakeAPart;
    }

    public void setPlaceAndFormForThoseWhoWantToTakeAPart(String placeAndFormForThoseWhoWantToTakeAPart) {
        this.placeAndFormForThoseWhoWantToTakeAPart = placeAndFormForThoseWhoWantToTakeAPart;
    }

    public String getDeadlineForSubmitAnApplicationForAuction() {
        return deadlineForSubmitAnApplicationForAuction;
    }

    public void setDeadlineForSubmitAnApplicationForAuction(String deadlineForSubmitAnApplicationForAuction) {
        this.deadlineForSubmitAnApplicationForAuction = deadlineForSubmitAnApplicationForAuction;
    }

    public String getDeadlineForWarrantyPayment() {
        return deadlineForWarrantyPayment;
    }

    public void setDeadlineForWarrantyPayment(String deadlineForWarrantyPayment) {
        this.deadlineForWarrantyPayment = deadlineForWarrantyPayment;
    }

    public String getTotalOpenedBiddingLimit() {
        return totalOpenedBiddingLimit;
    }

    public void setTotalOpenedBiddingLimit(String totalOpenedBiddingLimit) {
        this.totalOpenedBiddingLimit = totalOpenedBiddingLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passport)) return false;

        Passport passport = (Passport) o;

        if (auctionDate != null ? !auctionDate.equals(passport.auctionDate) : passport.auctionDate != null)
            return false;
        if (auctionStepAndAmountRaiseCondition != null ? !auctionStepAndAmountRaiseCondition.equals(passport.auctionStepAndAmountRaiseCondition) : passport.auctionStepAndAmountRaiseCondition != null)
            return false;
        if (auctionTime != null ? !auctionTime.equals(passport.auctionTime) : passport.auctionTime != null)
            return false;
        if (bankInfoForRegistrationPayment != null ? !bankInfoForRegistrationPayment.equals(passport.bankInfoForRegistrationPayment) : passport.bankInfoForRegistrationPayment != null)
            return false;
        if (contactPersonInBankToReviewTheProperty != null ? !contactPersonInBankToReviewTheProperty.equals(passport.contactPersonInBankToReviewTheProperty) : passport.contactPersonInBankToReviewTheProperty != null)
            return false;
        if (deadlineForSubmitAnApplicationForAuction != null ? !deadlineForSubmitAnApplicationForAuction.equals(passport.deadlineForSubmitAnApplicationForAuction) : passport.deadlineForSubmitAnApplicationForAuction != null)
            return false;
        if (deadlineForWarrantyPayment != null ? !deadlineForWarrantyPayment.equals(passport.deadlineForWarrantyPayment) : passport.deadlineForWarrantyPayment != null)
            return false;
        if (lotsForSale != null ? !lotsForSale.equals(passport.lotsForSale) : passport.lotsForSale != null)
            return false;
        if (numberAndDateOfComitetAboutSalesCondition != null ? !numberAndDateOfComitetAboutSalesCondition.equals(passport.numberAndDateOfComitetAboutSalesCondition) : passport.numberAndDateOfComitetAboutSalesCondition != null)
            return false;
        if (participantsNumberCondition != null ? !participantsNumberCondition.equals(passport.participantsNumberCondition) : passport.participantsNumberCondition != null)
            return false;
        if (placeAndFormForThoseWhoWantToTakeAPart != null ? !placeAndFormForThoseWhoWantToTakeAPart.equals(passport.placeAndFormForThoseWhoWantToTakeAPart) : passport.placeAndFormForThoseWhoWantToTakeAPart != null)
            return false;
        if (procedureForReviewTheProperty != null ? !procedureForReviewTheProperty.equals(passport.procedureForReviewTheProperty) : passport.procedureForReviewTheProperty != null)
            return false;
        if (publicAuctionOrganizer != null ? !publicAuctionOrganizer.equals(passport.publicAuctionOrganizer) : passport.publicAuctionOrganizer != null)
            return false;
        if (totalOpenedBiddingLimit != null ? !totalOpenedBiddingLimit.equals(passport.totalOpenedBiddingLimit) : passport.totalOpenedBiddingLimit != null)
            return false;
        if (urlForElectronicAuction != null ? !urlForElectronicAuction.equals(passport.urlForElectronicAuction) : passport.urlForElectronicAuction != null)
            return false;
        if (warrantyPayment != null ? !warrantyPayment.equals(passport.warrantyPayment) : passport.warrantyPayment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lotsForSale != null ? lotsForSale.hashCode() : 0;
        result = 31 * result + (numberAndDateOfComitetAboutSalesCondition != null ? numberAndDateOfComitetAboutSalesCondition.hashCode() : 0);
        result = 31 * result + (publicAuctionOrganizer != null ? publicAuctionOrganizer.hashCode() : 0);
        result = 31 * result + (warrantyPayment != null ? warrantyPayment.hashCode() : 0);
        result = 31 * result + (participantsNumberCondition != null ? participantsNumberCondition.hashCode() : 0);
        result = 31 * result + (bankInfoForRegistrationPayment != null ? bankInfoForRegistrationPayment.hashCode() : 0);
        result = 31 * result + (auctionStepAndAmountRaiseCondition != null ? auctionStepAndAmountRaiseCondition.hashCode() : 0);
        result = 31 * result + (procedureForReviewTheProperty != null ? procedureForReviewTheProperty.hashCode() : 0);
        result = 31 * result + (contactPersonInBankToReviewTheProperty != null ? contactPersonInBankToReviewTheProperty.hashCode() : 0);
        result = 31 * result + (auctionDate != null ? auctionDate.hashCode() : 0);
        result = 31 * result + (auctionTime != null ? auctionTime.hashCode() : 0);
        result = 31 * result + (urlForElectronicAuction != null ? urlForElectronicAuction.hashCode() : 0);
        result = 31 * result + (placeAndFormForThoseWhoWantToTakeAPart != null ? placeAndFormForThoseWhoWantToTakeAPart.hashCode() : 0);
        result = 31 * result + (deadlineForSubmitAnApplicationForAuction != null ? deadlineForSubmitAnApplicationForAuction.hashCode() : 0);
        result = 31 * result + (deadlineForWarrantyPayment != null ? deadlineForWarrantyPayment.hashCode() : 0);
        result = 31 * result + (totalOpenedBiddingLimit != null ? totalOpenedBiddingLimit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Passport{ \n" +
                "   lotsForSale='" + lotsForSale + ",\n" +
                "   numberAndDateOfComitetAboutSalesCondition='" + numberAndDateOfComitetAboutSalesCondition + ",\n" +
                "   publicAuctionOrganizer='" + publicAuctionOrganizer + ",\n" +
                "   warrantyPayment='" + warrantyPayment + ",\n" +
                "   participantsNumberCondition='" + participantsNumberCondition + ",\n" +
                "   bankInfoForRegistrationPayment='" + bankInfoForRegistrationPayment + '\'' +
                "   auctionStepAndAmountRaiseCondition='" + auctionStepAndAmountRaiseCondition + ",\n" +
                "   procedureForReviewTheProperty='" + procedureForReviewTheProperty + '\'' +
                "   contactPersonInBankToReviewTheProperty='" + contactPersonInBankToReviewTheProperty + ",\n" +
                "   auctionDate='" + auctionDate + ",\n" +
                "   auctionTime='" + auctionTime + ",\n" +
                "   urlForElectronicAuction='" + urlForElectronicAuction + ",\n" +
                "   placeAndFormForThoseWhoWantToTakeAPart='" + placeAndFormForThoseWhoWantToTakeAPart + ",\n" +
                "   deadlineForSubmitAnApplicationForAuction='" + deadlineForSubmitAnApplicationForAuction + ",\n" +
                "   deadlineForWarrantyPayment='" + deadlineForWarrantyPayment + ",\n" +
                "   totalOpenedBiddingLimit='" + totalOpenedBiddingLimit + ",\n" +
                '}' + "\n";
    }
}
