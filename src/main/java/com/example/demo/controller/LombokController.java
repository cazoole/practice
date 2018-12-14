package com.example.demo.controller;

import com.example.demo.domain.PersonDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LombokController {

    @Autowired
    private PersonDO personDO;

    @RequestMapping(value = "/lombok", method = RequestMethod.GET)
    public Object getPerson() {
        log.info("lombok getPerson:");

        return  null;
    }
}
