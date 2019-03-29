package com.example.demo.dynamic.scheduled.jobs;

import com.example.demo.dynamic.scheduled.BasedJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class CounterJob extends BasedJob {

    public CounterJob(String name, String group) {
        super(name, group);
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    }
}
