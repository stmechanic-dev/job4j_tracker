package ru.job4j.tracker.collection.dep;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Arr = o1.split("/");
        String[] o2Arr = o2.split("/");
        boolean result = o1Arr[0].compareTo(o2Arr[0]) == 0;
        return result ? o1.compareTo(o2) : o2.compareTo(o1);
    }
}
