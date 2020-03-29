package com.code.practise.design.adapt;

public class AnnotationController implements Controller {

    @Override
    public void handle() {
        System.out.println("AnnotationController");
    }
}
