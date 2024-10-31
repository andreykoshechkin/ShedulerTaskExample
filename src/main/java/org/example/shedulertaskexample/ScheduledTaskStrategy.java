package org.example.shedulertaskexample;

public interface ScheduledTaskStrategy {
    void execute();
    default String getTaskName(){
       return this.getClass().getSimpleName();
    };

}
