package com.code.dora.job;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledTask {

    @Scheduled(fixedDelayString = "${query.frequency}")
    public void oder(){

    }

}
