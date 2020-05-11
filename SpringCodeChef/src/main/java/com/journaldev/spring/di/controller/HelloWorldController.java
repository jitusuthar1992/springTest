package com.journaldev.spring.di.controller;

import com.journaldev.spring.di.component.AsyncCaller;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

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

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "login";

    }

    @RequestMapping("/admin")
    public ModelAndView helloAdmin(ModelMap model, Principal principal) {

        String loggedInUserName=principal.getName();

        return new ModelAndView("admin", "userName", loggedInUserName);
    }

    @RequestMapping(value="/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";

    }

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied(Principal user) {

        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", You can not access this page!");
        } else {
            model.addObject("msg",
                    "You can not access this page!");
        }

        model.setViewName("403");
        return model;
    }
}
