package com.reborn.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

// 스케쥴러 스레드 POOL을 설정해주는 곳이 있어야 채팅과 안겹침.
@Configuration
public class SchedulerConfig implements SchedulingConfigurer{
	private final int POOL_SIZE = 10;

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		// TODO Auto-generated method stub
		
	}
	
	@Bean
	public TaskScheduler taskScheduler() {
	    ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
	    taskScheduler.setPoolSize(10);
	    taskScheduler.initialize();
	    return taskScheduler;
	}
	

}
