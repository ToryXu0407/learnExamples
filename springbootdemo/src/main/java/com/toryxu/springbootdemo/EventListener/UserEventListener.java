package com.toryxu.springbootdemo.EventListener;

import com.toryxu.springbootdemo.User;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/3/5 5:16 下午
 * 通过@Async配置异步事件监听，前提是开启@Async，通过配置@EnableAsync
 */
@Component
public class UserEventListener {
    @EventListener
    @Async
    public void handleEvent(User user) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("接收到事件啦哈哈");
    }
}
