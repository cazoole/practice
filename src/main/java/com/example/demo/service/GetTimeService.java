package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: wei.liuw
 * @Date: 2018/8/10 15:03
 * @version: $Id: practice, v 0.1 2018年08月2018/8/10日 wei.liuw EXP $
 */
@Service
public class GetTimeService {
    private static final Logger logger = LoggerFactory.getLogger(GetTimeService.class);

    public String getCurrentTime() {
        logger.info("获取系统当前时间：");
        return new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date());
    }

}
