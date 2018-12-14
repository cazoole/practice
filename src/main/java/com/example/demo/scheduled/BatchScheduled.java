package com.example.demo.scheduled;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BatchScheduled {

    private static int count = 0;

//    @Scheduled(fixedDelay = 10 * 1000)
    public void doBatchJob(){
        log.info("第一次job执行：");
        count += 1;
        log.info("count = " + count);
    }

}
