package com.reborn.web.config;


import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration //been객체 등록
@EnableAsync //비동기 선언
public class AsyncConfig {
	
	@Bean(name = "mailExecutor")
    public Executor fooExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(30);
        taskExecutor.setThreadNamePrefix("mailExecutor-");
        taskExecutor.initialize();
        return taskExecutor;
    }
}
