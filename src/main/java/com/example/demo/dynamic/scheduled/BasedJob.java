package com.example.demo.dynamic.scheduled;

import org.quartz.Job;

/**
 * 基础任务类型
 */
public abstract class BasedJob implements Job {

    private String name;
    private String group;

    public BasedJob(String name, String group) {
        this.name = name;
        this.group = group;
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
