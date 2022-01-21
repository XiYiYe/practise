package com.code.dora.exception;

import com.code.dora.result.StatusCodeEnum;
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

    public CustomizedException(Integer code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }


    public CustomizedException(Throwable throwable) {
        super(throwable);
    }

}
