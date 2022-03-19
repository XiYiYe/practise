package com.code.dora.design.strategy;

import com.code.dora.constant.ChangeTypeEnum;
import com.google.common.collect.Lists;
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

    public void handleByType(String type, Integer value) {
        if (StringUtils.isNotBlank(type)) {
            Optional.ofNullable(MAP.get(type))
                    .ifPresent(consumer -> consumer.accept(value));
        }
    }

    private void updateHandle(Integer value) {
    }

    private void newHandle(Integer value) {
    }

    private void deleteHandle(Integer value) {
    }
}
