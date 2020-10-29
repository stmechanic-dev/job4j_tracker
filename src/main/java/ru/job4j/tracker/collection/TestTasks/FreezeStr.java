package ru.job4j.tracker.collection.TestTasks;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean result = false;
        Map<Character, Integer> leftMap = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            if (leftMap.putIfAbsent(left.charAt(i), 1) != null) {
                leftMap.put(left.charAt(i), leftMap.get(left.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < right.length(); i++) {
            if (leftMap.containsKey(right.charAt(i))) {
                if (leftMap.get(right.charAt(i)) == 1) {
                    leftMap.remove(right.charAt(i));
                } else {
                    leftMap.put(right.charAt(i), leftMap.get(right.charAt(i)) - 1);
                }
            } else {
                break;
            }
        }
        if (leftMap.isEmpty()) {
            result = true;
        }
        return result;
    }
}