package job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author: toryxu
 * @Date: 2018/10/8 0008 10:29
 * @Version 1.0
 */
public class QuartzManager {

    public static void addJob() throws SchedulerException, InterruptedException {
        //schedule工厂类实例
        SchedulerFactory sf = new StdSchedulerFactory();
        //代表一个Quartz的独立运行容器，Trigger和JobDetail可以注册在Scheduler中
        Scheduler sched = sf.getScheduler();
        //job实现接口定义运行任务，即运行simpleJob
        JobDetail job = JobBuilder.newJob(SimpleJob.class).withIdentity("myJob", "group1").build();
        //trigger描述触发job执行的时间触发规则。
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
        sched.scheduleJob(job, trigger);
        sched.start();
        Thread.sleep(10000l);
        CronTrigger newtrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1").withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")).build();
        sched.rescheduleJob(new TriggerKey("trigger1", "group1"), newtrigger);
    }
}
