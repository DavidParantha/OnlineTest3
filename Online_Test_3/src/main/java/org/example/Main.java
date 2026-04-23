package org.example;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        File folder = new File("logs");
        File[] files = folder.listFiles();

        ActivityAggregator aggregator = new ActivityAggregator();
        ArrayList<LogProcessor> threads = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    LogProcessor t = new LogProcessor(file.getPath(), aggregator);
                    threads.add(t);
                    t.start();
                    System.out.println("strating thred for : " + file.getName());
                }
            }
        } else {
            System.out.println("no files fownd in logs folder");
        }

        for (LogProcessor t : threads) {
            try {
                t.join();
            } catch (Exception e) {
                System.out.println("thred erorr");
            }
        }

        ReportGenerator.generate(aggregator.getData());

    }

}
