package com.code.practise.design.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomizedEventListener implements ApplicationListener<CustomizedEvent> {

    @Override
    public void onApplicationEvent(CustomizedEvent event) {
        log.info("monitor event: {}", event);
        //执行业务逻辑
    }
}
