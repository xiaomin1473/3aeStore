package com.ae.job.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler {

	public static void main(String[] args) {
		// 创建一个JobDetail实例，将该实例与HelloJob Class绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
								.withIdentity("myJob", "group")
								.build();

		// 输出JobDetails
		System.out.println("jobDetail's name: " + jobDetail.getKey().getName());
		System.out.println("jobDetail's group: " + jobDetail.getKey().getGroup());
		System.out.println("jobDetail's jobClass" + jobDetail.getJobClass().getName());
		

		// 创建一个trigger实例，定义该job立即执行，并且每隔两秒钟重复一次，直到永远
		Trigger trigger = TriggerBuilder
							.newTrigger()
							.withIdentity("myJob", "group")
							.startNow()
							.withSchedule(
								SimpleScheduleBuilder.simpleSchedule()
									.withIntervalInSeconds(2)
									.repeatForever())
							.build();
		
		// 创建Scheduler实例
		SchedulerFactory sfact = new StdSchedulerFactory();
		try {
			Scheduler scheduler = sfact.getScheduler();
			
			scheduler.start();
			
			// 打印当前的执行时间，格式为2000-00-00 00:00:00
			Date date = new Date();
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("Current time is: " + sFormat.format(date));
			
			scheduler.scheduleJob(jobDetail, trigger);
			
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
