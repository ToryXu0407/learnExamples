package threads;

import java.util.concurrent.Callable;

/**
 * @Author: toryxu
 * @Date: 2019/3/18 0018 15:26
 * @Version 1.0
 */
public class ThreadCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("job 1");
        return 1;
    }
}
