package com.code.practise.design.adapt;

public class AnnotationHandlerAdapter implements HandleAdapter {

    @Override
    public boolean support(Object object) {
        return object instanceof AnnotationController;
    }

    @Override
    public void handle(Object object) {
        ((AnnotationController) object).handle();
    }
}
