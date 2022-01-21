package com.code.dora.design.adapt;

public class AnnotationController implements Controller {

    @Override
    public void handle() {
        System.out.println("AnnotationController");
    }
}
