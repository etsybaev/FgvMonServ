package com.fgvmonserv.service;

import jodd.mail.SmtpServer;
import jodd.mail.SendMailSession;
import jodd.mail.Email;
import jodd.mail.SmtpSslServer;

/**
 * Created by ievgeniit on 23.01.17.
 */
public class JavaGmailSSLExample {

    public static void main(String[] args) {
        SmtpServer smtpServer = SmtpSslServer
                .create("smtp.gmail.com")
                .authenticateWith("myEmail@host.com", "myPass");

        SendMailSession session = smtpServer.createSession();

        session.open();

        Email email = Email.create()
                .from("myEmail@host.com")
                .to("myDestinationEmail@host.com")
                .subject("send from app")
                .addText("a plain text message");

        session.sendMail(email);

        session.close();

        System.out.println("done.");
    }

}

