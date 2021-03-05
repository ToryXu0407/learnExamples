package com.toryxu.springbootdemo;

import com.toryxu.springbootdemo.EventListener.UserEventRegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/3/5 5:12 下午
 */
@RestController
public class Controller {

    @Autowired
    private UserEventRegisterServiceImpl userEventRegisterServiceImpl;

    @GetMapping("/eventTest")
    public void eventTest() {

        userEventRegisterServiceImpl.register();
    }
}
