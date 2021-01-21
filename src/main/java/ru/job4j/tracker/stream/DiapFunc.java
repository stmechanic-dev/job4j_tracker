package ru.job4j.tracker.stream;

import ru.job4j.tracker.block4.Function;

import java.util.ArrayList;
import java.util.List;

public class DiapFunc {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(func.apply((double) i));
        }
        return list;
    }
}
