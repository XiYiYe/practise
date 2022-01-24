package com.code.dora.util;

import com.code.dora.constant.CacheTypeEnum;
import com.code.dora.bean.CacheObject;
import com.code.dora.exception.CustomizedException;
import com.code.dora.constant.ResultCodeEnum;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

/**
 * @author by Dora
 * @Date 2022/1/21 15:25
 */
@Slf4j
public class LocalCacheUtils {

    private static final Map<String, Cache<String, CacheObject>> LOCAL_CACHE_MAP = new ConcurrentHashMap<>(16);

    private static final Object LOCK = new Object();

    public static <T> T get(CacheTypeEnum cacheTypeEnum, String key, Supplier<T> supplier) {
        boolean switchOn = switchOn(cacheTypeEnum);
        if (!switchOn) {
            if (log.isDebugEnabled()) {
                log.debug("local cache is closed, biz {}", cacheTypeEnum.name());
            }
        }
        return getCache(cacheTypeEnum, key, supplier);
    }

    public static <T> T getCache(CacheTypeEnum cacheTypeEnum, String key, Supplier<T> supplier) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        Cache<String, CacheObject> cache = getCache(cacheTypeEnum, false);
        CacheObject cacheObject;
        try {
            cacheObject = cache.get(key, () -> {
                if (log.isDebugEnabled()) {
                    log.debug("local cache not hit, cacheBiz {} cacheKey {}", cacheTypeEnum.name(), key);
                }
                atomicBoolean.set(false);
                T value = supplier == null ? null : supplier.get();
                return new CacheObject(value, cacheTypeEnum.name());
            });
        } catch (ExecutionException ex) {
            log.error("local cache exception, biz {}, key {}", cacheTypeEnum.name(), key);
            throw new CustomizedException(ResultCodeEnum.FAIL.getCode(), "get cache error");
        }
        if (atomicBoolean.get() && log.isDebugEnabled()) {
            log.debug("local cache hit, biz {}, key {}", cacheTypeEnum.name(), key);
        }
        return (T) cacheObject.getValue();
    }

    public static Cache<String, CacheObject> getCache(CacheTypeEnum cacheTypeEnum, boolean allowCacheNull) {
        Cache<String, CacheObject> cacheObject = LOCAL_CACHE_MAP.get(cacheTypeEnum.name());
        if (cacheObject != null || allowCacheNull) {
            return cacheObject;
        }
        synchronized (LOCK) {
            cacheObject = LOCAL_CACHE_MAP.get(cacheTypeEnum.name());
            if (cacheObject != null) {
                return cacheObject;
            }
            long maxCacheSize = cacheTypeEnum.getSize() == null ? 1000 : cacheTypeEnum.getSize();
            cacheObject = CacheBuilder.newBuilder().recordStats().expireAfterWrite(cacheTypeEnum.getExpiredTime(),
                    cacheTypeEnum.getTimeUnit()).maximumSize(maxCacheSize).build();
            LOCAL_CACHE_MAP.put(cacheTypeEnum.name(), cacheObject);
            return cacheObject;
        }
    }


    /**
     * 这里应该是读取统一配置中心配置的缓存key的bool值，先暂时这样写
     * @param cacheTypeEnum 缓存业务
     * @return 开关
     */
    private static boolean switchOn(CacheTypeEnum cacheTypeEnum) {
        String preKey = cacheTypeEnum.getBiz();
        return BooleanUtils.isTrue(Boolean.getBoolean(System.getProperty(preKey)));
    }
}
