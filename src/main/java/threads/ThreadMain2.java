package threads;

/**
 * @Author: toryxu
 * @Date: 2019/3/18 0018 14:00
 * @Version 1.0
 */
public class ThreadMain2 {


    public static void main(String[] args) throws InterruptedException {
        int i ;
       for( i=0;i<100;i++){
           Thread thread = new Thread(new Runnable() {
               @Override
               public void run() {
                   System.out.println(Thread.currentThread().getName());
               }
           },"join-"+i);
           thread.start();
           thread.join();
       }
        System.out.println("let's get it");
    }
}
