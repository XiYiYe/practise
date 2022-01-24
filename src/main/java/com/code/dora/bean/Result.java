package com.code.dora.bean;

import com.code.dora.constant.ResultCodeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author by Dora
 * @Date 2022/1/24 10:29
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public Boolean isSuccess() {
        return ResultCodeEnum.SUCCESS.getCode().equals(code);
    }

    public Result(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
