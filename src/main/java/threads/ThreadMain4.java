package threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: toryxu
 * @Date: 2019/3/18 0018 17:29
 * @Version 1.0
 */
public class ThreadMain4 {
    public static void main(String[] args) throws InterruptedException {
        int count = 100;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("fuck");
            }
        });
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
//        System.out.println("let's get it");
    }
}
