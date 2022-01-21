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

    FAIL(500, "FAIL"),
    ;

    private Integer code;

    private String message;

    StatusCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
