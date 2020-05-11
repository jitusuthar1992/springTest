package com.journaldev.spring.di.component;

import org.springframework.stereotype.Component;

import java.util.Map;

public class AsyncMailTrigger {
    public void senMail(Map<String,String> properties) {

        System.out.println("Trigger mail in a New Thread :: "  + Thread.currentThread().getName());
        properties.forEach((K,V)->System.out.println("Key::" + K + " Value ::" + V));
    }
}
