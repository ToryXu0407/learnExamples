package threads;

/**
 * @Author: toryxu
 * @Date: 2019/3/18 0018 13:45
 * @Version 1.0
 */
public class ThreadMain {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadOne());
        Thread t2 = new Thread(new ThreadTwo());
        Thread t3 = new Thread(new ThreadThree());
        try{
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
            System.out.println("let's get it 1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
