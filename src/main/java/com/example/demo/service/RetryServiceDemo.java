package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class RetryServiceDemo {

    private static final Logger logger = LoggerFactory.getLogger(RetryServiceDemo.class);

    private int currentCnt = 0;

    @Retryable(value = RuntimeException.class, maxAttempts = 3)
    public void testRetry() {
        logger.info("testRetry 第" + (++currentCnt) + "次运行开始：");
        throw new RuntimeException("未知异常");
    }

    @Recover
    public void afterRetry() {
        logger.info("testRetry attempt fail. Do recover!");
    }
}
