package com.bj.hh.quartzscheduler.control;

import com.bj.hh.quartzscheduler.job.ShowInfoJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2023/2/1 15:11
 */
@RestController
public class SchedulerController {

    @RequestMapping(value = "/scheduler",method = RequestMethod.GET)
    public String schedulerController() throws SchedulerException {
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        //作业类
        JobDetail jobDetail = JobBuilder.newJob(ShowInfoJob.class)
                .withIdentity("jobName", "jobGroup").build();
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
        CronTrigger trigger = TriggerBuilder.newTrigger().withSchedule(cronScheduleBuilder)
                .withIdentity("triggerName", "triggerGroup")
                .withDescription("").startNow().build();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
        return "启动成功";
    }
}
