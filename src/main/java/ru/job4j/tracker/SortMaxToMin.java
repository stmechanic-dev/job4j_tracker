package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortMaxToMin implements Comparator<Item> {

    public static void sort(List<Item> list) {
        Collections.sort(list, Collections.reverseOrder());
    }

    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
