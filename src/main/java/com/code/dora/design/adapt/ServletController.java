package com.code.dora.design.adapt;

public class ServletController implements Controller {

    @Override
    public void handle() {
        System.out.println("ServletController");
    }

}
