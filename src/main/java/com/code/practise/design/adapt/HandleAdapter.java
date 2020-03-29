package com.code.practise.design.adapt;

/**
 * 模拟SpringMvc的适配器模式
 */
public interface HandleAdapter {

    /**
     * 是否支持该接口
     * @return
     */
    boolean support(Object object);

    /**
     * 执行相应的操作
     */
    void handle(Object object);

}
