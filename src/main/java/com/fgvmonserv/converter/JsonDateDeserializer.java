package com.fgvmonserv.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;
//import java.time.Instant;
import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created by ievgeniit on 02.06.17.
 */
public class JsonDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        ObjectCodec oc = jp.getCodec();
        TextNode node = (TextNode) oc.readTree(jp);
        String dateString = node.textValue();

        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
//        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

//        Instant instant = Instant.parse(dateString);
//        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//        LocalDate date = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth());
        return date;
    }
}