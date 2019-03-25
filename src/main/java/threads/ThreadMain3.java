package threads;

import java.util.concurrent.*;

/**
 * @Author: toryxu
 * @Date: 2019/3/18 0018 15:25
 * @Version 1.0
 * callable
 *  * 一、创建执行线程的方式三：实现 Callable 接口。 相较于实现 Runnable 接口的方式，方法可以有返回值，并且可以抛出异常。
 *  *
 *  * 二、执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。  FutureTask 是  Future 接口的实现类
 */
public class ThreadMain3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor =Executors.newCachedThreadPool ();
        for(int i=0;i<10000;i++){
            FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return Thread.currentThread().getName();
                }
            });
            Future fut =executor.submit(ft);
//            Thread thread  = new Thread(ft);
//            thread.start();
//            thread.join();
            System.out.println("gaga"+fut.get());
            System.out.println(ft.get());
        }
        executor.shutdown();
    }
}
