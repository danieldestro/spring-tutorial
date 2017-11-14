package com.example.service;

import java.io.Closeable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ReportService implements Closeable {

    private StringBuilder content = new StringBuilder();

    public StringBuilder generateReport(String text) {

        final int lines = (int) (Math.random() * 100);
        System.out.println("Lines: " + lines);

        for (int i = 0; i < lines; i++) {
            addLine("This is line " + i + " of report " + toString().split("@")[1] + " running on thread " + text + "\n");
            sleep();
        }

        return content;
    }

    public void addLine(String text) {
        content.append(text);
    }

    @Override
    public void close() {
        content = new StringBuilder();
    }

    public void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }
}
