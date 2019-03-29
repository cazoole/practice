package com.example.demo.controller;

import com.example.demo.dynamic.scheduled.BasedJob;
import com.example.demo.dynamic.scheduled.QuartzJobManager;
import com.example.demo.dynamic.scheduled.jobs.CounterJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cron")
@Slf4j
public class ChangeableJobController {

    @Autowired
    private QuartzJobManager quartzJobManager;

    @RequestMapping("/add")
    public String createJob() {
        BasedJob basedJob = new CounterJob("test", "default");
        try {
            quartzJobManager.addJob(basedJob, "0/3 * * * * ?");
        } catch (SchedulerException e) {
            log.error("创建任务失败", e);
        }
        return "create";
    }

    @RequestMapping("/update")
    public String updateJob() {
        BasedJob basedJob = new CounterJob("test", "default");

        try {
            quartzJobManager.updateJob(basedJob, "0/5 * * * * ?");
        } catch (SchedulerException e) {
            log.error("创建任务失败", e);
        }

        return "update";
    }
}
