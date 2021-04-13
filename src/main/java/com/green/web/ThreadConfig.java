package com.green.web;

import java.util.concurrent.ThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadConfig {
    @Bean(name = "regular-thread-pool")
    public ThreadPoolTaskExecutor taskExecutor() {
        final ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setThreadFactory(threadFactory());
        taskExecutor.setThreadNamePrefix("green-test");
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setQueueCapacity(20);
        return taskExecutor;
    }





    @Bean
    public ThreadFactory threadFactory() {
        return new CustomizableThreadFactory("test-");
    }
}
