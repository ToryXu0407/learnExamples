//package job;
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//
//import java.util.Date;
//
//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;
//
///**
// * @Author: toryxu
// * @Date: 2018/10/8 0008 9:03
// * @Version 1.0
// */
//public class test  implements Job {
//    @Override
//    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        println(Thread.currentThread().getName() + " test job begin ");
//    }
//    public static void main(String[] args) throws InterruptedException, SchedulerException {
//
//        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//        // 开始
//        scheduler.start();
//        // job 唯一标识 test.test-1
//        JobKey jobKey = new JobKey("test" , "test-1");
//        JobDetail jobDetail = JobBuilder.newJob(test.class).withIdentity(jobKey).build();
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .withIdentity("test" , "test")
//                // 延迟一秒执行
//                .startAt(new Date(System.currentTimeMillis() + 1000))
//                // 每隔一秒执行 并一直重复
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
//                .build();
//        scheduler.scheduleJob(jobDetail , trigger);
//
//        Thread.sleep(5000);
//        // 删除job
//        scheduler.deleteJob(jobKey);
//}
//
//
//}
