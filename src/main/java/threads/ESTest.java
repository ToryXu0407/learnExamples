package threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/1/20 9:30 下午
 */
public class ESTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(0);
        while (true) {
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            CompletableFuture<Void>[] futureList = new CompletableFuture[10];
            int i = 10;
            try {
                while (i-- > 0) {
                    futureList[i] = CompletableFuture.supplyAsync(() -> {
                        try {
                            Thread.sleep(1000
                            );
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }, executorService);
                }
                CompletableFuture.allOf(futureList)
                        .exceptionally(e -> {
//                        log.error(e.getMessage(), e);
                            return null;
                        }).join();
            } finally {
//            if (executorService != null) {
                ThreadPoolExecutor tpe = (ThreadPoolExecutor) executorService;
                System.out.println();

                int queueSize = tpe.getQueue().size();
                System.out.println("当前排队线程数：" + queueSize);

                int activeCount = tpe.getActiveCount();
                System.out.println("当前活动线程数：" + activeCount);

                long completedTaskCount = tpe.getCompletedTaskCount();
                System.out.println("执行完成线程数：" + completedTaskCount);

                long taskCount = tpe.getTaskCount();
                System.out.println("总线程数：" + taskCount);
                tpe.shutdown();
                executorService.shutdown();
                System.out.println(executorService.isShutdown());
//            }
            }
            Thread.sleep(3000);
        }


    }
}
