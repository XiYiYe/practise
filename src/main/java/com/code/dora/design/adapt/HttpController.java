package com.code.dora.design.adapt;

public class HttpController implements Controller {

    @Override
    public void handle() {
        System.out.println("HttpController");
    }
}
