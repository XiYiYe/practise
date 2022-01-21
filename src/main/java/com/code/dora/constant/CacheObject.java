package com.code.dora.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by 叶雪辉
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
