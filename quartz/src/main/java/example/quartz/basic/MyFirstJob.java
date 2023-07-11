package example.quartz.basic;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyFirstJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("MyFirstJob started at : " + arg0.getFireTime());
		System.out.println("MyFirstJob finished : " + arg0.getFireInstanceId());
	}

}
