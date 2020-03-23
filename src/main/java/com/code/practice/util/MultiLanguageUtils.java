package com.code.practice.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 多语言国际化工具类
 */
@Component
public class MultiLanguageUtils {

    @Resource
    private MessageSource messageSource;

    private static MessageSource localMessageSource;

    @PostConstruct
    private void init() {
        localMessageSource = messageSource;
    }

    /**
     * 获取国际化messages
     * @param key
     * @return
     */
    public static String getMessage(String key) {
        return getMessage(key, null);
    }

    /**
     * 获取国际化messages
     * @param key messages.properties的key
     * @param args messages的占位符{}
     * @return
     */
    public static String getMessage(String key, Object[] args) {
        return localMessageSource.getMessage(key, args, key, LocaleContextHolder.getLocale());
    }

}
