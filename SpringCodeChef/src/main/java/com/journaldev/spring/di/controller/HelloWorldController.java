package com.journaldev.spring.di.controller;

import com.journaldev.spring.di.component.AsyncCaller;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    private static final Logger logger = Logger.getLogger(HelloWorldController.class);

    @Autowired
    private AsyncCaller asyncCaller;

    @RequestMapping("/helloworld")
    public ModelAndView hello() {
        String helloWorldMessage = "Hello world from java2blog!";

        asyncCaller.rightWayToCall();
        asyncCaller.wrongWayToCall();
        return new ModelAndView("hello", "message", helloWorldMessage);
    }
}
