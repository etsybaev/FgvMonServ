package com.fgvmonserv.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ievgeniit on 07.06.17.
 */
public class DateTimeConverter {

//    private String regex = "(?!^)\\+|[^-.\\d]+";

    public static LocalDate parseLocalDate(String localDate){

        if(localDate == null || localDate.isEmpty()){
            return null;
        }

        if(localDate.contains(",")){
            localDate = localDate.replaceAll(",","."); //if data looks like 27,01,2017 then change commas to dots
        }

        List<DateTimeFormatter> knownPatterns = Arrays.asList(DateTimeFormatter.ofPattern("dd.MM.yyyy"),
                DateTimeFormatter.ISO_DATE,
                DateTimeFormatter.BASIC_ISO_DATE,
                DateTimeFormatter.ISO_LOCAL_DATE);

        for(DateTimeFormatter dateTimeFormatter : knownPatterns){
            try {
                return LocalDate.parse(localDate.replaceAll("[^0-9.]+", ""), dateTimeFormatter);
            } catch (DateTimeParseException e){
                //doNothing. This is just a loop to find necessary pattern to parse.
            }
        }
        System.err.println("WARNING!!! Didn't manage to find right DateTimeFormatter pattern to parse " + localDate);
        return null;
    }
}
