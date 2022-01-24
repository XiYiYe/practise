package com.code.dora.design.observer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author by Dora
 * @Date 2021/10/9 10:46
 * @Description 发布订阅事件
 */
@Component
public class EventService {

    @Autowired
    private ApplicationContext applicationContext;

    public void pushEvent(Message message) {
        applicationContext.publishEvent(new CustomizedEvent<>(this, message));
    }

}
