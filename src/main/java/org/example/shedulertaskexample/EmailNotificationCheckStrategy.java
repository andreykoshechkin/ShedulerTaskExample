package org.example.shedulertaskexample;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Slf4j
@Service
public class EmailNotificationCheckStrategy implements ScheduledTaskStrategy {


    @Override
    public void execute() {
        log.info("Email notification check strategy started");
        //Логика
    }


}
