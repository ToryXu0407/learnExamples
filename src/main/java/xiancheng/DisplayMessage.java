package xiancheng;

/**
 * @Author: toryxu
 * @Date: 2018/11/6 0006 13:59
 * @Version 1.0
 */
public class DisplayMessage implements Runnable {
    private String message;

    public DisplayMessage(String message) {
        this.message = message;
    }

    public void run() {
        while(true) {
            System.out.println(message);
        }
    }
}