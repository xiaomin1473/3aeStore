package store.ae.job.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// 打印当前的执行时间，格式为2000-00-00 00:00:00
		Date date = new Date();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current exec time is: " + sFormat.format(date));
		
		// 任务
		System.out.println("hello job");
	}

}
