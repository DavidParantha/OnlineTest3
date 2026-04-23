package org.example;

import java.io.FileWriter;
import java.util.Map;

public class ReportGenerator {

    public static void generate(Map<String, Integer> data) {

        System.out.println("===== USER ACTIVITY REPORT =====");

        try {
            FileWriter fw = new FileWriter("report.txt");
            fw.write("===== USER ACTIVITY REPORT =====\n");

            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " actions");
                fw.write(entry.getKey() + ": " + entry.getValue() + " actions\n");
            }

            fw.close();
            System.out.println("reprot saved to report.txt");

        } catch (Exception e) {
            System.out.println("faild to write reprot");
        }

    }

}