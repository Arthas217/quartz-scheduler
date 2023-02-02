package com.bj.hh.quartzscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 定时任务启动类
 */
@SpringBootApplication
public class QuartzSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzSchedulerApplication.class, args);
    }

}
