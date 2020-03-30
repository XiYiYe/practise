package com.code.practise.design.observer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class EventService {

    @Autowired
    private ApplicationContext applicationContext;

    public void pushEvent(Message message) {
        applicationContext.publishEvent(new CustomizedEvent<>(this, message));
    }

}
