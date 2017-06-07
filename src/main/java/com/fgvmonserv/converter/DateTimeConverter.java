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

    public static LocalDate parseLocalDate(String localDate){
        List<DateTimeFormatter> knownPatterns = Arrays.asList(DateTimeFormatter.ofPattern("dd.MM.yyyy"),
                DateTimeFormatter.ISO_DATE,
                DateTimeFormatter.BASIC_ISO_DATE,
                DateTimeFormatter.ISO_LOCAL_DATE);

        for(DateTimeFormatter dateTimeFormatter : knownPatterns){
            try {
                return LocalDate.parse(localDate, dateTimeFormatter);
            } catch (DateTimeParseException e){
                //doNothing. This is just a loop to find necessary pattern to parse.
            }
        }
        System.err.println("ERROR!!! Didn't manage to find right DateTimeFormatter pattern to parse " + localDate);
        return null;
    }
}
