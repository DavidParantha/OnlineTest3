package org.example;

import java.util.HashMap;
import java.util.Map;

public class ActivityAggregator {

    HashMap<String, Integer> activityMap = new HashMap<>();

    public synchronized void add(String userId) {
        if (activityMap.containsKey(userId)) {
            activityMap.put(userId, activityMap.get(userId) + 1);
        } else {
            activityMap.put(userId, 1);
        }
    }

    public Map<String, Integer> getData() {
        return activityMap;
    }

}