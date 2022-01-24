package com.code.dora.exception;

import com.code.dora.constant.ResultCodeEnum;
import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class CustomizedException extends RuntimeException {

    private Integer code;

    private String message;

    public CustomizedException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
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
