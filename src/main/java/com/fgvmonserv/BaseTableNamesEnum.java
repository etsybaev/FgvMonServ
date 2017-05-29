package com.fgvmonserv;


/**
 * Created by ievgeniit on 29.05.17.
 */
public enum BaseTableNamesEnum {

    ID("id", "Id"),
    BANK("bank", "Bank"),
    AUCTION_DATE("auctionDate", "Auction Date"),
    LOT_NUMBER("lotNumber", "Lot Number"),
    KD_NUMBER("kdNumber", "KD Number"),
    ABOUT_AUCTION("aboutAuction", "About auction"),
    START_PRICE("startPrice", "Start Price"),
    URL("url", "URL"),
    PROPERTY_DETAILS("propertyDetails", "Property details"),
    LOAN_DEBTOR_FULL_NAME("loanDebtorFullName", "Loan debtor full name"),
    LOAN_DEBTOR_PHONE_NUMBER("loanDebtorPhoneNumber", "Loan debtor phone number"),
    LOAN_DEBTOR_IDENT_CODE("loanDebtorIdentCode", "Loan debtor Ident code"),
    DETAILS("details", "Details"),
    DATE_OF_CALL("dateOfCall", "Date of call"),
    STATUS_OF_CALL("statusOfCall", "Status of call"),
    NEW_PRICE("newPrice", "New price"),
    NEW_AUCTION_DATE("newAuctionDate", "New Auction date"),
    AUCTION_NUMBER("auctionNumber", "Auction number"),
    SYMPTOM("symptom", "Symptom");


    private String dbName;
    private String viewName;

    BaseTableNamesEnum(String dbName, String viewName){
        this.dbName = dbName;
        this.viewName =  viewName;
    }

    public String getDbName(){
        return dbName;
    }

    public String getViewName(){
        return viewName;
    }


    public static String getViewNameFromDbName(String dbName){
        for(BaseTableNamesEnum e: BaseTableNamesEnum.values()){
            if(e.getDbName().equals(dbName)){
                return e.viewName;
            }
        }
        throw new IllegalArgumentException("Wrong argument! Enum with value " + dbName + " doesn't exist");
    }

}
