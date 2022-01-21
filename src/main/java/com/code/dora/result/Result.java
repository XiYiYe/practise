package com.code.dora.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用返回对象
 * @param <T>
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public Result(StatusCodeEnum statusCodeEnum) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getMessage();
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
