package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.MyComponent;

public class MyAppAnnotations {

    public static void main(String[] args) {

        // load configurations and create an application context
        ApplicationContext context = new ClassPathXmlApplicationContext("annotation-context.xml");

        // lookup the bean by id
        MyComponent service = context.getBean(MyComponent.class);
        service.showMeTheMoney();

        reports(context);
    }

    private static void reports(final ApplicationContext context) {

        Runnable task = () -> {
            MyComponent service = context.getBean(MyComponent.class);
            String name = Thread.currentThread().getName();
            service.generateReport(name);
        };

        // ExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(task);
        executor.submit(task);

        executor.shutdown();
    }
}
