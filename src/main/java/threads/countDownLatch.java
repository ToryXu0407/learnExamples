package threads;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: toryxu
 * @Date: 2019/3/18 0018 14:28
 * @Version 1.0
 * CountdownLatch可同时阻塞多个线程，但它们可并发执行
 */
public class countDownLatch {
    public static void main(String[] args) throws InterruptedException {
        int count = 100;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for(int i=0;i<count;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    countDownLatch.countDown();
//                    try {
//                        countDownLatch.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("hh");
                }
            },"job"+i);
            thread.start();
            thread.join();

        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("let's get it");
    }
}
