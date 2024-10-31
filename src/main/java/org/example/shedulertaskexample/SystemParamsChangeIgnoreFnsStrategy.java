package org.example.shedulertaskexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SystemParamsChangeIgnoreFnsStrategy implements ScheduledTaskStrategy {

    String oldValue = "Д";
    String newValue = "Н";

    @Override
    public void execute() {
        log.info("System parameter 'ignore_ffff' changed from '{}' to '{}'.", oldValue, newValue);
        //Тут логика
    }

}
