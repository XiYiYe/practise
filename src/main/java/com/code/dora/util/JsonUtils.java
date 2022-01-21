package com.code.dora.util;

import com.alibaba.fastjson.JSON;

/**
 * @author by Dora
 * @Date 2021/10/9 10:34
 * @Description
 */
public class JsonUtils {

    public static String toString(Object object) {
        return object == null ? null : JSON.toJSONString(object);
    }

}
