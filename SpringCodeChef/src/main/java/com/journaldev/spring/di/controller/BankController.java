package com.journaldev.spring.di.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BankController {
    private static final Logger logger = Logger.getLogger(BankController.class);

    @RequestMapping(value = "/banktransfer", method = RequestMethod.GET)
    public String banktransfer() {

        return "banktransfer";
    }


    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    @ResponseBody
    public String transfer(@RequestParam("accountNo") int accountNo,
                           @RequestParam("amount") final int amount) {
        logger.info("Transfer to "+ accountNo);
        return amount+" transferred to account "+ accountNo;
    }

    @ResponseBody
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String transfer2(@RequestParam("accountNo") int accountNo,
                          @RequestParam("amount") final int amount) {
        logger.info("Transfer to "+ accountNo);
        return amount+" transferred to account "+ accountNo;
    }
}
