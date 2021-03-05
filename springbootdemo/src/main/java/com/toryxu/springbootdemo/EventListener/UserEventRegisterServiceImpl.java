package com.toryxu.springbootdemo.EventListener;

import com.toryxu.springbootdemo.User;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/3/5 5:15 下午
 */
@Service
public class UserEventRegisterServiceImpl implements UserEventRegisterService {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void register() {
        User user = new User();
        user.setName("ToryXu");
        user.setAge(24);
        //同步,先执行监听方法，再往下执行
        applicationEventPublisher.publishEvent(user);
        System.out.println("注册结束");
    }
}
