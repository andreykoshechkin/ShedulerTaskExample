package org.example.shedulertaskexample;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class RepeatCheckFNNN implements ScheduledTaskStrategy {


    @Override
    public void execute() {
        log.info("Attempting to recheck using method 'checkaaa2' for document ID: {}", BigDecimal.TEN);
        //Логика
    }

}
