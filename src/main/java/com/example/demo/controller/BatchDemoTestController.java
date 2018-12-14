//package com.example.demo.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.JobParametersInvalidException;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
//import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
//import org.springframework.batch.core.repository.JobRestartException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//
//@RestController("/batch")
//@Slf4j
//public class BatchDemoTestController {
//
//    @Autowired
//    private JobLauncher jobLauncher;
//
//    @Autowired
//    @Qualifier("importUserJob")
//    private Job importUserJob;
//
//    @RequestMapping("/do")
//    public Object startBatchJob() {
//        log.info("第一次job执行：");
//        try {
//            jobLauncher.run(importUserJob,
//                    new JobParametersBuilder().addDate("importUserJob", new Date()).toJobParameters());
//        } catch (JobExecutionAlreadyRunningException e) {
//            log.error("", e);
//        } catch (JobRestartException e) {
//            e.printStackTrace();
//        } catch (JobInstanceAlreadyCompleteException e) {
//            e.printStackTrace();
//        } catch (JobParametersInvalidException e) {
//            e.printStackTrace();
//        }
//        return "ok";
//    }
//}
