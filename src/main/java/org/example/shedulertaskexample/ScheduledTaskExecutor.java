package org.example.shedulertaskexample;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduledTaskExecutor {
    private final List<ScheduledTaskStrategy> strategies;

    // Задача выполняется в 00:00
    @Scheduled(cron = "0 0 0 * * ?", zone = "Europe/Moscow")
    public void executeHelloWorldTask() {
        executeTaskForStrategy(0); // Индекс или логика для выбора стратегии
    }

    // Задача выполняется каждую минуту с 00:00 по 00:59
    @Scheduled(cron = "0 * 0 * * ?", zone = "Europe/Moscow")
    public void executeCheckDataTask() {
        executeTaskForStrategy(1); // Индекс или логика для выбора стратегии
    }

    // Задача выполняется в 01:00
    @Scheduled(cron = "0 0 1 * * ?", zone = "Europe/Moscow")
    public void executeAnalyzeLogsTask() {
        executeTaskForStrategy(2); // Индекс или логика для выбора стратегии
    }

    private void executeTaskForStrategy(int index) {
        if (index >= 0 && index < strategies.size()) {
            ScheduledTaskStrategy strategy = strategies.get(index);
            Try.run(strategy::execute)
                    .onSuccess(e -> log.info("Executed scheduled: {}", strategy.getClass().getSimpleName()))
                    .onFailure(e -> log.error("Error executing strategy: {}", strategy.getClass().getSimpleName(), e));
        } else {
            log.error("Invalid strategy index: {}", index);
        }
    }
}
