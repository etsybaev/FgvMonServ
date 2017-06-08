package com.fgvmonserv.enums;

/**
 * Created by ievgeniit on 08.06.17.
 */
public enum SearchByRangeTypeEnum {
    START_FROM("Start from Date", ">="),
    EQUALS_TO("Equals to Date", "=");

    private String viewName;
    private String sqlSymbol;

    SearchByRangeTypeEnum(String viewName, String sqlSymbol){
        this.viewName = viewName;
        this.sqlSymbol = sqlSymbol;
    }

    public String getViewName() {
        return viewName;
    }

    public String getSqlSymbol() {
        return sqlSymbol;
    }
}
