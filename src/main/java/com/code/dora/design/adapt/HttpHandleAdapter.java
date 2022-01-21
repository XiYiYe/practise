package com.code.dora.design.adapt;

public class HttpHandleAdapter implements HandleAdapter {

    @Override
    public boolean support(Object object) {
        return object instanceof HttpController;
    }

    @Override
    public void handle(Object object) {
        ((HttpController)object).handle();
    }
}
