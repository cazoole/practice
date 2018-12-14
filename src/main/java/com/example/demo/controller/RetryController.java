package com.example.demo.controller;

import com.example.demo.service.RetryServiceDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetryController {

    private static final Logger logger = LoggerFactory.getLogger(RetryController.class);

    @Autowired
    private RetryServiceDemo retryServiceDemo;

    @RequestMapping(value = "testRetry", method = RequestMethod.GET)
    public Object retryTest() {
        logger.info("retryTest begin test:");
        retryServiceDemo.testRetry();
        logger.info("retryTest do test.");
        return "end";
    }
}
