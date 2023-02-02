package com.bj.hh.quartzscheduler.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2023/2/1 15:09
 */
public class ShowInfoJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        // 这里就是具体编写定时任务要执行的代码
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        System.out.println("执行runTask方法: " + date);
    }
}
