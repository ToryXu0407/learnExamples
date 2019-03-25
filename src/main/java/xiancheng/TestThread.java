package xiancheng;
//new一个runnable开启线程，在线程中拿到本线程并Thread.sleep
class runnable implements Runnable {
    private Thread t;
    private String threadName;

    runnable( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

public class TestThread {

    public static void main(String args[]) {
        runnable R1 = new runnable( "Thread-1");
        R1.start();
        runnable R2 = new runnable( "Thread-2");
        R2.start();
    }
}