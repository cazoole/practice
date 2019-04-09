package com.example.demo.dynamic.scheduled.jobs;

import com.example.demo.dynamic.scheduled.BasedJob;
import com.example.demo.service.GetTimeService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class CounterJob extends BasedJob {
    static int counter = 0;

    @Autowired
    private GetTimeService getTimeService;

    public CounterJob() {

    }

    public CounterJob(String name, String group) {
        this();
        this.setName(name == null ? this.getClass().getName() : name);
        this.setGroup(group == null ? "baseJob" : group);
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(String.format("%s： 第%d次执行Job任务，当前时间：%s", this.getClass().getName(), counter++, LocalDateTime.now()));
        System.out.println("getTimeService : " + getTimeService.getCurrentTime());
    }
}
