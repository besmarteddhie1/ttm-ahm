package com.ahm.jx.ttm.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.ahm.jx.ttm.component.SynchDataTasks;
 
 
@Configuration
@EnableScheduling
public class SchedullerConfig implements SchedulingConfigurer {
 
    @Bean
    public SynchDataTasks bean() {
        return new SynchDataTasks();
    }
 
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }
 
    @Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(10);
    }
 
}

