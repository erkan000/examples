package example.quartz.basic;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class StartMyFirstJob {
	
	private static final String freq = "0/5 * * * * ?"; // at every 5 seconds
	
	public static void main(String[] args) throws SchedulerException {
		
		JobDetail jobDetail = JobBuilder.newJob(MyFirstJob.class).build();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("MyFirstJobTrigger")
				.withSchedule(CronScheduleBuilder.cronSchedule(freq)).build();
		Scheduler scheduler;
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		System.out.println("Non-blocking methods, waiting on quartz event loop");
	}

}
