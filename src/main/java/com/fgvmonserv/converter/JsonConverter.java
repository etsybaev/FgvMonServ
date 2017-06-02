package com.fgvmonserv.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by ievgeniit on 02.06.17.
 */
public class JsonConverter {

    public String convertToJson(Object object){
        ObjectMapper objectMapper = new ObjectMapper();
        String objectAsJsonString = null;
        try {
            objectAsJsonString = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return objectAsJsonString;
    }

    public <T> T convertJsonToObject(String objectAsJsonString, Class<T> expectedClass, boolean failOnUnknownProperties){
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknownProperties);
        try {
            return objectMapper.readValue(objectAsJsonString, expectedClass);
        } catch (IOException e) {
//            throw new RuntimeException("Was not able to map user entity from client response. Details: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
