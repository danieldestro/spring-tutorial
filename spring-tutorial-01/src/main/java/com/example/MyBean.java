package com.example;

public class MyBean {

    private static int counter = 0;

    private String     name;

    public MyBean() {
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCounter() {
        return counter;
    }

    public void close() {
        System.out.println("MyBean destroy");
    }
}
