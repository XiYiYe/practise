package com.code.practise.design.observer;

import com.code.practise.design.strategy.OrderEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.code.practise");
        context.publishEvent(new CustomizedEvent<>(context, new Message(OrderEnum.GROUP.getType())));
    }

}
