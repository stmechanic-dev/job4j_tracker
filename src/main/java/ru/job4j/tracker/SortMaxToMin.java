package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortMaxToMin {

    public static void sort(List<Item> list) {
        Collections.sort(list, Collections.reverseOrder());
    }
}
