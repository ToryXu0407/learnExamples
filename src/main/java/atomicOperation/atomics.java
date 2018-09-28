package atomicOperation;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: toryxu
 * @Date: 2018/9/26 0026 14:59
 * @Version 1.0
 * 原子操作类
 * AtomicInteger
 */
public class atomics {
        private static AtomicInteger num = new AtomicInteger(0);

        public static void main(String[] args) {
            for (int i = 0; i < 5; i++) {
                new Thread(()->{
                    System.out.print(num.getAndIncrement());
                }).start();
            }
            System.out.println(num.get());
        }
}
