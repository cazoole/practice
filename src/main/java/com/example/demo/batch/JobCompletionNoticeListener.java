//package com.example.demo.batch;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.BatchStatus;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.listener.JobExecutionListenerSupport;
//
////@Component
//@Slf4j
//public class JobCompletionNoticeListener extends JobExecutionListenerSupport {
//
////    @Autowired
//    public JobCompletionNoticeListener() {
//    }
//
//    @Override
//    public void afterJob(JobExecution jobExecution) {
//        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
//            log.info("Job has done!");
//
//        }
//    }
//}
