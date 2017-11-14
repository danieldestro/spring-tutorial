package com.example;

public class MyService {

    private MyBean bean;

    public MyService(MyBean bean) {
        this.bean = bean;
    }

    public void doSomething() {
        System.out.println(bean.getName());
    }
}
