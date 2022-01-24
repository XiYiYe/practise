package com.code.dora.constant;

import lombok.Getter;
import lombok.ToString;

/**
 * @author by Dora
 * @date 2022/1/24 10:30
 * 状态码
 */
@Getter
@ToString
public enum ResultCodeEnum implements ResultCode {

    /**
     * 状态码
     */
    SUCCESS(200, "SUCCESS"),

    /**
     * 非法的参数
     */
    ILLEGAL_PARAM(404, "param is illegal"),

    /**
     * 服务器异常
     */
    FAIL(500, "EOORO"),
    ;

    private Integer code;

    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
