import java.net.*;

import javax.swing.JOptionPane;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class ZoomTrigger {
    public static void main(String[] args) throws URISyntaxException, SchedulerException {
        JobDetail job = JobBuilder.newJob(ZoomJob.class).build();

        Trigger triggerOne = TriggerBuilder.newTrigger().withIdentity("SimpleTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();

        Scheduler schedule = StdSchedulerFactory.getDefaultScheduler();
        schedule.start();
        schedule.scheduleJob(job, triggerOne);
        System.out.println("Process started.");
    }
}
