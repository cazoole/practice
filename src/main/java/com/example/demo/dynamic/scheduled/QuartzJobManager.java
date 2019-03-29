package com.example.demo.dynamic.scheduled;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class QuartzJobManager {

    @Autowired
    private Scheduler scheduler;

    // 无参数的任务新增
    public void addJob(BasedJob currentJob, String cronExpression) throws SchedulerException {
        scheduler.start();

        // 启动任务
        scheduler.scheduleJob(getJobDetail(currentJob), getCronTrigger(currentJob, cronExpression));
    }

    // 有参数的任务新增
    public void addJob(BasedJob currentJob, String cronExpression, Map<String, Object> dataMap) throws SchedulerException {
        scheduler.start();

        // 创建任务
        scheduler.scheduleJob(getJobDetail(currentJob), fillData4CronTrigger(getCronTrigger(currentJob, cronExpression), dataMap));
    }

    // 无参数的job更新
    public void updateJob(BasedJob currentJob, String cronExpression) throws SchedulerException {
        // 刷新trigger
        scheduler.rescheduleJob(getTriggerKey(currentJob),
                getExistCronTrigger(currentJob, cronExpression));
    }

    // 无参数的job更新
    public void updateJob(BasedJob currentJob, String cronExpression, Map<String, Object> dataMap) throws SchedulerException {
        // 刷新trigger
        scheduler.rescheduleJob(getTriggerKey(currentJob),
                fillData4CronTrigger(
                        getExistCronTrigger(currentJob, cronExpression), dataMap));
    }

    // 删除任务
    public void deleteJob(BasedJob currentJob) throws SchedulerException {
        scheduler.pauseTrigger(getTriggerKey(currentJob));
        scheduler.unscheduleJob(getTriggerKey(currentJob));
        scheduler.deleteJob(JobKey.jobKey(currentJob.getName(), currentJob.getGroup()));
    }

    // 创建新的job任务
    private JobDetail getJobDetail(BasedJob currentJob) {
        return JobBuilder.newJob(currentJob.getClass())
                .withIdentity(currentJob.getName(), currentJob.getGroup())
                .build();
    }

    // 获取任务
    private CronTrigger getCronTrigger(BasedJob currentJob, String cronExpression) {
        // 解析表达式
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        // 获取job trigger对象
        return TriggerBuilder.newTrigger()
                .withSchedule(cronScheduleBuilder)
                .withIdentity(currentJob.getName(), currentJob.getGroup())
                .build();
    }

    // 组装参数
    private CronTrigger fillData4CronTrigger(CronTrigger cronTrigger, Map<String, Object> map) {
        cronTrigger.getJobDataMap().putAll(map);
        return cronTrigger;
    }

    // 获取已有的Tigger
    private CronTrigger getExistCronTrigger(BasedJob currentJob, String cronExpression) throws SchedulerException {
        // 解析表达式
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
        // 设置trigger的表达式只
        return ((CronTrigger) scheduler.getTrigger(getTriggerKey(currentJob)))
                .getTriggerBuilder()
                .withIdentity(currentJob.getName(), currentJob.getGroup())
                .withIdentity(getTriggerKey(currentJob))
                .withSchedule(cronScheduleBuilder).build();

    }

    // 获取job的triggerKey
    private TriggerKey getTriggerKey(BasedJob currentJob) {
        return TriggerKey.triggerKey(currentJob.getName(), currentJob.getGroup());
    }
}
