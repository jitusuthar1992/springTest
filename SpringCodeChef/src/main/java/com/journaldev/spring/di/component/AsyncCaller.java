package com.journaldev.spring.di.component;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class AsyncCaller {


    private static final Logger logger = Logger.getLogger(AsyncCaller.class);


    @Autowired
    private AsyncMailTrigger asyncMailTrigger ;

    public void setAsyncMailTrigger(AsyncMailTrigger asyncMailTrigger) {
        this.asyncMailTrigger = asyncMailTrigger;
    }

    public AsyncMailTrigger getAsyncMailTrigger() {
        return asyncMailTrigger;
    }

    @Async
    public void rightWayToCall() {
        logger.info("Calling From rightWayToCall Thread " + Thread.currentThread().getName());
        asyncMailTrigger.senMail(populateMap());
    }
    public void wrongWayToCall() {
        logger.info("Calling From wrongWayToCall Thread " + Thread.currentThread().getName());
        AsyncMailTrigger asyncMailTriggerObject = new AsyncMailTrigger();
        asyncMailTriggerObject.senMail(populateMap());
    }
    private Map<String,String> populateMap(){
        Map<String,String> mailMap= new HashMap<String,String>();
        mailMap.put("body", "A Ask2Shamik Article");
        return mailMap;
    }
}
