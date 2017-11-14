package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

    public static void main(String[] args) {

        // load configurations and create an application context
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        // lookup the bean by id
        MyService service = (MyService) context.getBean("myService");
        service.doSomething();

        // lookup the bean by type, if only a single definition exists
        MyBean bean = context.getBean(MyBean.class);
        bean.setName("Angelina Jolie");
        service.doSomething();
        System.out.println(MyBean.getCounter());

        // lookup the bean by type, if only a single definition exists
        bean = context.getBean(MyBean.class);
        bean.setName("Jennifer Aniston");
        System.out.println(MyBean.getCounter());
    }
}
