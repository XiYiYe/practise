package com.code.dora.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by Dora
 * @Date 2022/1/21 15:40
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheObject {

    /**
     * 缓存对象
     */
    private Object value;

    /**
     * 版本
     */
    private String version;
}
