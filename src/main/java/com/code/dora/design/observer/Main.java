package com.code.dora.design.observer;

import com.code.dora.design.strategy.OrderEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
//观察者模式
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.code.dora");
        context.publishEvent(new CustomizedEvent<>(context, new Message(OrderEnum.GROUP.getType())));
    }

}
