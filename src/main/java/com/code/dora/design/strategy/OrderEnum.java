package com.code.dora.design.strategy;

/**
 * 订单类型
 */
public enum OrderEnum {

    /**
     * 普通订单
     */
    NORMAL(1),

    /**
     * 促销订单
     */
    PROMOTION(2),

    /**
     * 团购订单
     */
    GROUP(3);

    private Integer type;

    OrderEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
