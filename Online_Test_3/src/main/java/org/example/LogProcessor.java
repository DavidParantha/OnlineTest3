package org.example;
import java.io.BufferedReader;
import java.io.FileReader;

public class LogProcessor extends Thread {
    String  filePath;
    ActivityAggregator aggregator;
    LogProcessor(String filePath, ActivityAggregator aggregator) {
        this.filePath =filePath;
        this.aggregator =     aggregator;
    }
    public void run() {
        try {
             BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
       String[] parts = line.split(" ");

                if (parts.length == 3) {
                    String userId = parts[1];
  String action = parts[2];
                    LogEntry entry =new LogEntry(parts[0 ], userId, action);
                    aggregator.add(entry.userId );
                } else {
                        System.out.println("invalidee line skiped :   " +line);
                }
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Eroor reading file :    " +filePath);
        }
    }

}
