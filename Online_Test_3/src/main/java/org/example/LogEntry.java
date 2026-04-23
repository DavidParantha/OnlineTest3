package org.example;

public class LogEntry {

    String timstamp;
    String userId;
    String action;

    LogEntry(String timstamp, String userId, String action) {
        this.timstamp = timstamp;
        this.userId = userId;
        this.action = action;
    }

}