package com.code.dora.design.strategy;

import com.code.dora.constant.ChangeTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author by Dora
 * @date 2022/3/19 9:46 PM
 */
@Component
public class FunctionStrategy {

    private static final Map<String, Consumer<Integer>> MAP = new HashMap<>(8);

    @PostConstruct
    private void init() {
        MAP.put(ChangeTypeEnum.NEW.name(), this::newHandle);
        MAP.put(ChangeTypeEnum.UPDATE.name(), this::updateHandle);
        MAP.put(ChangeTypeEnum.DELETE.name(), this::deleteHandle);
    }

    /**
     * 使用策略模式(保证了开闭原则，只对扩展开放)
     * 根据不同类型执行不同的操作
     *
     * @param type  类型 {@link ChangeTypeEnum}
     * @param value 待处理的值
     */
    public void handleByType(String type, Integer value) {
        if (StringUtils.isNotBlank(type)) {
            Optional.ofNullable(MAP.get(type))
                    .ifPresent(consumer -> consumer.accept(value));
        }
    }

    /**
     * 使用if/else
     * 根据不同类型执行不同的操作
     *
     * @param type  类型 {@link ChangeTypeEnum}
     * @param value 待处理的值
     */
    public void normalHandleByType(String type, Integer value) {
        if (ChangeTypeEnum.NEW.name().equals(type)) {
            newHandle(value);
        }
        if (ChangeTypeEnum.UPDATE.name().equals(type)) {
            updateHandle(value);
        }
        if (ChangeTypeEnum.DELETE.name().equals(type)) {
            deleteHandle(value);
        }
    }

    private void updateHandle(Integer value) {
        System.out.println("update value:" + value);
    }

    private void newHandle(Integer value) {
        System.out.println("new value:" + value);
    }

    private void deleteHandle(Integer value) {
        System.out.println("delete value:" + value);
    }
}
