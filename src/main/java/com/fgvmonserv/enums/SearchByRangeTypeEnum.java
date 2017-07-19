package com.fgvmonserv.enums;

/**
 * Created by ievgeniit on 08.06.17.
 */
public enum SearchByRangeTypeEnum {
    START_FROM("Start from Date"),
    EQUALS_TO("Equals to Date");

    private String viewName;

    SearchByRangeTypeEnum(String viewName){
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }
}
