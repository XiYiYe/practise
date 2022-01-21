package com.code.dora.bean;

import lombok.Data;

@Data
public class LogBO {

    private String className;

    private String method;

    private Object parameter;

    private String description;

    private Object result;

    private Object spendTime;

}
