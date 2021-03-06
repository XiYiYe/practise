package com.code.practise.exception;

import com.code.practise.response.Result;
import com.code.practise.response.StatusCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalHandleException {

    @ExceptionHandler(CustomizedException.class)
    public Result handleCustomizedException(CustomizedException ex) {
        log.warn("code:{}, message:{}", ex.getCode(), ex.getMessage());
        return new Result(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public Result handleServerException(Throwable ex) {
        log.warn("server exception,", ex);
        return new Result(StatusCodeEnum.FAIL);
    }

}
