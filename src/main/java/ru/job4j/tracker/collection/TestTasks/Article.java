package ru.job4j.tracker.collection.TestTasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String tmp = origin.replaceAll("\\.", "");
        tmp = tmp.replaceAll(",", "");
        tmp = tmp.replaceAll(";", "");
        tmp = tmp.replaceAll(":", "");
        tmp = tmp.replaceAll("!", "");
        Set<String> origSet = new HashSet<>(Arrays.asList(tmp.split(" ")));
        Set<String> lineSet = new HashSet<>(Arrays.asList(line.split(" ")));
        for (String s : lineSet) {
            if (!(origSet.contains(s))) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
