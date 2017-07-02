package io.github.sruby.quartz.guide;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Once you obtain a scheduler using StdSchedulerFactory.getDefaultScheduler(), 
 * your application will not terminate until you call scheduler.shutdown(), because there will be active threads.
 * @author liuwf on Jun 29, 2017 9:10:56 PM
 */
public class QuartzTest
{
	public static void main(String[] args)
	{
		try
		{
			// Grab the Scheduler instance from the Factory
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			// and start it off
			scheduler.start();
			
//			To do something interesting, you need code between the *start()* and *shutdown()* calls.
//			JobDetail job = new job();
			
			//stop
			scheduler.shutdown();
			
		}
		catch (SchedulerException se)
		{
			se.printStackTrace();
		}
	}
}