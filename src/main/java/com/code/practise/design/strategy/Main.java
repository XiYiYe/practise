package com.code.practise.design.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.code.practise");
        StrategyContext strategyContext = context.getBean("strategyContext", StrategyContext.class);
        OrderService orderService = (OrderService) strategyContext.getBean(OrderEnum.GROUP);
        orderService.handle();
    }

}
