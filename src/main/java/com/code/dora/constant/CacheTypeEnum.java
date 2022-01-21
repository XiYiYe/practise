package com.code.dora.constant;

import java.util.concurrent.TimeUnit;

/**
 * @author by Dora
 * @Date 2022/1/21 15:36
 * @Description
 */
public enum CacheTypeEnum {

    /**
     * 定义缓存业务
     */
    ;

    /**
     * 缓存业务
     */
    private String biz;

    /**
     * 缓存过期时间
     */
    private Long expiredTime;

    /**
     * 过期时间单位
     */
    private TimeUnit timeUnit;

    /**
     * 缓存大小
     */
    private Long size;

    CacheTypeEnum(String biz, Long expiredTime, TimeUnit timeUnit, Long size) {
        this.biz = biz;
        this.expiredTime = expiredTime;
        this.timeUnit = timeUnit;
        this.size = size;
    }

    public String getBiz() {
        return biz;
    }

    public Long getExpiredTime() {
        return expiredTime;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public Long getSize() {
        return size;
    }
}

