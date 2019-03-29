package com.example.demo.dynamic.scheduled.jobs;

import com.example.demo.dynamic.scheduled.BasedJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

public class CounterJob extends BasedJob {
    static int counter = 0;

    public CounterJob() {

    }

    public CounterJob(String name, String group) {
        this();
        this.setName(name);
        this.setGroup(group);
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(String.format("第%d次执行Job任务，当前时间：%s", counter++, LocalDateTime.now()));
    }


}
