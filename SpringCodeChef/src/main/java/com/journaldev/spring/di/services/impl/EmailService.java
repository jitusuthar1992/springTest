package com.journaldev.spring.di.services.impl;

import com.journaldev.spring.di.services.MessageService;

public class EmailService  implements MessageService {

    public boolean sendMessage(String msg, String rec) {
        System.out.println("Email Sent to "+rec+ " with Message="+msg);
        return true;
    }
}

