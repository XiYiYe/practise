package com.code.dora.design.strategy;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 策略类型注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Type {

    /**
     * type值
     */
    OrderEnum value() default OrderEnum.NORMAL;

}
