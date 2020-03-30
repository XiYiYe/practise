package com.code.practise.design.adapt;

/**
 * Spring通过（HandlerAdapter）适配器接口，使得每一种处理器（宽泛的概念Controller，以及HttpRequestHandler，Servlet，等等）
 * 有一种对应的适配器实现类，让适配器代替（宽泛的概念Controller，以及HttpRequestHandler，Servlet，等等）执行相应的方法。
 * 这样在扩展Controller 时，只需要增加一个适配器类就完成了SpringMVC的扩展
 * 核心就是HandleAdapter适配Controller
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
