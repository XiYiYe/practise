package com.code.practice.exception;

import lombok.Getter;

@Getter
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
