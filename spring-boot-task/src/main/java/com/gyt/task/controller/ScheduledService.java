package com.gyt.task.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    /**
     * second, minute, hour, day of month, month and day of week.
     * 0 * * * * MON-FRI  周一到周五每一分钟
     */
    @Scheduled(cron = "0 * * * * MON-FRI")
    public void hello() {
        System.out.println("hello");
    }
}
