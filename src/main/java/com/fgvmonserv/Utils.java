package com.fgvmonserv;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by ievgeniit on 02.06.17.
 */
public class Utils {

    public static String encodeToUrlUtf8(String inputString) {
        try {
            return URLEncoder.encode(inputString, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Was not able to encode string '" + inputString + "' to UTF-8 format.");
        }
    }


    public static String decodeFromUrlUtf8(String inputString) {
        try {
            return URLDecoder.decode(inputString, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Was not able to decode string '" + inputString + "' with UTF-8 format.");
        }
    }


}
