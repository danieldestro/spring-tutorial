package com.example.service;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    @Autowired
    private ApplicationContext           context;

    @Autowired
    private ObjectFactory<ReportService> prototypeFactory;

    @Autowired
    private AnotherService               service;

    public void showMeTheMoney() {
        service.callMeMayBe();
    }

    public void generateReport(String name) {
        // ReportService reportService = context.getBean(ReportService.class);
        ReportService reportService = prototypeFactory.getObject();

        StringBuilder report = reportService.generateReport(name);
        reportService.close();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String threadName = Thread.currentThread().getName();
        System.out.println("==========================================================");
        System.out.println(threadName + ": \n" + report);
    }
}
