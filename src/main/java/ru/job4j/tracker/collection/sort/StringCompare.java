package ru.job4j.tracker.collection.sort;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        if (left.length() == right.length()) {
            for (int i = 0; i < left.length(); i++) {
                result = Character.compare(left.charAt(i), right.charAt(i));
                if (result != 0) {
                    break;
                }
            }
        } else {
            int size = left.length() < right.length() ? left.length() : right.length();
            for (int i = 0; i < size; i++) {
                result = Character.compare(left.charAt(i), right.charAt(i));
                if (result != 0) {
                    break;
                }
            }
            if (result == 0 && left.length() > right.length()) {
                result = 1;
            } else if (result == 0 && left.length() < right.length()) {
                result = -1;
            }
        }

        return result;
    }
}
