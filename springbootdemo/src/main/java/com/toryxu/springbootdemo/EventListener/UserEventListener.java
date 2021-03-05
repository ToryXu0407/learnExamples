package com.toryxu.springbootdemo.EventListener;

import com.toryxu.springbootdemo.User;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/3/5 5:16 下午
 * 通过@Async配置异步事件监听，前提是开启@Async，通过配置@EnableAsync
 * 根据方法参数的类型来区分监听的事件。
 * 可以添加condition
 * 如果主线程中执行了数据库操作，必须等数据库事务提交完，才执行事件，
 * 则可以配置@TransactionEventListener
 */
@Component
public class UserEventListener {
    @EventListener(condition = "#user.age ==24")
//    @TransactionalEventListener
    @Async
    public void handleEvent(User user) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("接收到事件啦哈哈");
    }

//    @EventListener
//    public void afterRegisterSendMail(MessageEvent event) {
//        // Spring 4.2 之前
//        TransactionSynchronizationManager.registerSynchronization(
//                new TransactionSynchronizationAdapter() {
//                    @Override
//                    public void afterCommit() {
//                        internalSendMailNotification(event);
//                    }
//                });
//    }

}
