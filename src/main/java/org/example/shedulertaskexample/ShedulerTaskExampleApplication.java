package org.example.shedulertaskexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ShedulerTaskExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShedulerTaskExampleApplication.class, args);
    }

}
