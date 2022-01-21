package com.code.dora.design.adapt;

public class ServletHandleAdapter implements HandleAdapter {

    @Override
    public boolean support(Object object) {
        return object instanceof ServletController;
    }

    @Override
    public void handle(Object object) {
        ((ServletController) object).handle();
    }
}
