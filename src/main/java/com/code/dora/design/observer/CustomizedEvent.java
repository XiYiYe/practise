package com.code.dora.design.observer;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@Getter
@ToString
public class CustomizedEvent<Message> extends ApplicationEvent {

    private Message message;

    public CustomizedEvent(Object source, Message message) {
        super(source);
        this.message = message;
    }
}
