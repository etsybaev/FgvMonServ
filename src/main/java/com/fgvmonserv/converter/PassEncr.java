package com.fgvmonserv.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by ievgeniit on 28.06.17.
 */


public class PassEncr {

    public static void main(String args[]) throws Exception {
        String cryptedPassword = new BCryptPasswordEncoder().encode("1234");
        System.out.println(cryptedPassword.length());
        System.out.println(cryptedPassword);
    }

}
