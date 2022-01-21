package com.code.dora.result;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum StatusCodeEnum {

    /**
     * 状态码
     */
    SUCCESS(200, "SUCCESS"),

    /**
     * 非法的参数
     */
    ILLEGAL_PARAM(404, "param is illegal"),

    FAIL(500, "EOORO"),
    ;

    private Integer code;

    private String message;

    StatusCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
