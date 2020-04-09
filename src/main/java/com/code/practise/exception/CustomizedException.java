package com.code.practise.exception;

import com.code.practise.response.StatusCodeEnum;
import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class CustomizedException extends RuntimeException {

    private Integer code;

    private String message;

    public CustomizedException(StatusCodeEnum statusCodeEnum){
        super(statusCodeEnum.getMessage());
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getMessage();
    }

    public CustomizedException(Throwable throwable) {
        super(throwable);
    }

}
