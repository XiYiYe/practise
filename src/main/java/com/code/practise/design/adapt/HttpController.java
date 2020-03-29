package com.code.practise.design.adapt;

public class HttpController implements Controller {

    @Override
    public void handle() {
        System.out.println("HttpController");
    }
}
