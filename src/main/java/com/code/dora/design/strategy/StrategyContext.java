package com.code.dora.design.strategy;

import com.code.dora.exception.CustomizedException;
import com.code.dora.constant.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by Dora
 * @Date 2022/01/23 10:46
 * @Description 策略模式
 */
@Component
@Slf4j
public class StrategyContext implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Map<String, Object> beanFactory = new HashMap<>(8);

    /**
     * 初始化执行策略上下文
     */
    @PostConstruct
    private void init() {
        Map<String, Object> map = applicationContext.getBeansWithAnnotation(Type.class);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object object = entry.getValue();
            Type type = object.getClass().getAnnotation(Type.class);
            beanFactory.put(type.value().getType().toString(), object);
        }
    }

    @Override
    public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 获取执行策略
     * @param orderEnum
     * @return
     */
    public Object getBean(OrderEnum orderEnum) {
        Object object = beanFactory.get(orderEnum.getType().toString());
        if (object == null) {
            log.warn("can not find execute strategy bean");
            throw new CustomizedException(ResultCodeEnum.FAIL);
        }
        return object;
    }
}
