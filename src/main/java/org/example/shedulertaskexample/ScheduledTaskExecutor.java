package org.example.shedulertaskexample;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduledTaskExecutor {

    private final List<ScheduledTaskStrategy> strategies;

    // Задача выполняется в 00:00
    @Scheduled(cron = "0 10 22 * * ?", zone = "Europe/Moscow")
    public void executeHelloWorldTask() {
        executeTaskForStrategy(SystemParamsChangeIgnoreFnsStrategy.class);
    }

    // Задача выполняется каждую минуту с 00:00 по 00:59
    @Scheduled(cron = "0 10-15 22 * * *", zone = "Europe/Moscow")
    public void executeCheckDataTask() {
        executeTaskForStrategy(EmailNotificationCheckStrategy.class);
    }

    // Задача выполняется в 01:00
    @Scheduled(cron = "0 15 22 * * ?", zone = "Europe/Moscow")
    public void executeAnalyzeLogsTask() {
        executeTaskForStrategy(RepeatCheckFNNN.class);
    }

    private void executeTaskForStrategy(Class<? extends ScheduledTaskStrategy> strategyClass) {
        strategies.stream()
                .filter(strategy -> strategy.getClass().getSimpleName().equals(strategyClass.getSimpleName()))
                .findFirst()
                .ifPresent(strategy -> Try.run(strategy::execute)
                        .onSuccess(e -> log.info("Executed scheduled: {}", strategy.getTaskName()))
                        .onFailure(e -> log.error("Error executing strategy: {}", strategy.getTaskName(), e)));
    }
}

// @Scheduled(cron = "0 0 0 * * *", zone = "Europe/Moscow") 00:00
// @Scheduled(cron = "0 0 1 * * ?", zone = "Europe/Moscow") 01:00
// @Scheduled(cron = "0 * 0 * * ?") 00:00 - 00:59