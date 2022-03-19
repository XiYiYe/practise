package com.code.dora.constant;

/**
 * @author by Dora
 * @date 2022/3/11 6:36 PM
 */
public enum ChangeTypeEnum {

    /**
     * 新建
     */
    NEW("NEW"),

    /**
     * 更新
     */
    UPDATE("UPDATE"),

    /**
     * 删除
     */
    DELETE("DELETE");

    /**
     * 值
     */
    private String value;

    ChangeTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
