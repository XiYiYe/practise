package com.code.dora.util;

import com.code.dora.exception.CustomizedException;
import com.code.dora.result.StatusCodeEnum;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * @author by 叶雪辉
 * @Date 2021/10/9 10:46
 * @Description
 */
public class AssertUtils {

    public static void isNoNull(Object object, StatusCodeEnum resultEnum) {
        if(object == null) {
            throw new CustomizedException(resultEnum);
        }
    }

    public static void isNoNull(Object object) {
        isNoNull(object, StatusCodeEnum.ILLEGAL_PARAM);
    }

    public static void isNoNull(Object object, String message) {
        if (object == null) {
            throw new CustomizedException(StatusCodeEnum.ILLEGAL_PARAM.getCode(), message);
        }
    }

    public static void isNull(Object object, StatusCodeEnum resultEnum) {
        if(object != null) {
            throw new CustomizedException(resultEnum);
        }
    }

    public static void isNull(Object object) {
        if(object != null) {
            throw new CustomizedException(StatusCodeEnum.ILLEGAL_PARAM);
        }
    }

    public static void isNull(Object object, String message) {
        if(object != null) {
            throw new CustomizedException(StatusCodeEnum.ILLEGAL_PARAM.getCode(), message);
        }
    }

    public static void isNotBlank(String s, StatusCodeEnum resultEnum) {
        if(StringUtils.isBlank(s)) {
            throw new CustomizedException(resultEnum);
        }
    }

    public static void isNotBlank(String s){
        isNoNull(s, StatusCodeEnum.ILLEGAL_PARAM);
    }

    public static void isEqual(Object object1, Object object2, StatusCodeEnum resultEnum) {
        if(object1 == null && object2 == null) {
            return;
        }
        if (object1 != null && object1.equals(object2)) {
            return;
        }
        throw new CustomizedException(resultEnum);
    }

    public static void isNotEqual(Object object1, Object object2, StatusCodeEnum resultEnum) {
        if(object1 == null && object2 == null) {
            throw new CustomizedException(resultEnum);
        }
        if (object1 != null && object1.equals(object2)) {
            throw new CustomizedException(resultEnum);
        }
    }

    public static void isEqual(Object object1, Object object2) {
        isEqual(object1, object2, StatusCodeEnum.FAIL);
    }

    public static void isNotEqual(Object object1, Object object2) {
        isNotEqual(object1, object2, StatusCodeEnum.FAIL);
    }

    public static void isNotEmpty(Collection<?> collection) {
        isNotEmpty(collection, StatusCodeEnum.FAIL);
    }

    public static void isNotEmpty(Collection<?> collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new CustomizedException(StatusCodeEnum.FAIL.getCode(), message);
        }
    }

    public static void isTrue(Boolean status) {
        if (BooleanUtils.isNotTrue(status)) {
            throw new CustomizedException(StatusCodeEnum.FAIL);
        }
    }

    public static void isNotEmpty(Map map) {
        isNotEmpty(map, StatusCodeEnum.FAIL);
    }

    public static void isNotEmpty(Map map, String message) {
        if (map == null || map.isEmpty()) {
            throw new CustomizedException(StatusCodeEnum.FAIL.getCode(), message);
        }
    }

    public static void isNotEmpty(Map map, StatusCodeEnum resultEnum) {
        if (map == null || map.isEmpty()) {
            throw new CustomizedException(resultEnum);
        }
    }

    public static void isNotEmpty(Collection<?> collection, StatusCodeEnum resultEnum) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new CustomizedException(resultEnum);
        }
    }
}

