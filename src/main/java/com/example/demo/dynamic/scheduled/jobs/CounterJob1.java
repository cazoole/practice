package com.example.demo.dynamic.scheduled.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

public class CounterJob1 implements Job {
    static int counter = 0;
    private String name;
    private String group;

    public CounterJob1() {
    }

    public CounterJob1(String name, String group) {
        this();
        this.name = name;
        this.group = group;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(String.format("第%d次执行Job任务，当前时间：%s", counter++, LocalDateTime.now()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
