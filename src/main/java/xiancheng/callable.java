package xiancheng;

import java.util.concurrent.Callable;

/**
 * @Author: toryxu
 * @Date: 2018/11/6 0006 14:18
 * @Version 1.0
 */
public class callable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("fuck");
        Thread.sleep(5);
        return "fuck";
    }

    public static void main(String[] args) throws Exception {
        callable callable = new callable();
        System.out.println(callable.call());
    }
}
