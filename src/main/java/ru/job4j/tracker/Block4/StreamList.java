package ru.job4j.tracker.Block4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-1, 0, 5, -7, 2, 3, 6, -9);
        List<Integer> filt = list.stream().filter(x -> x > 0
                                ).collect(Collectors.toList());
        filt.forEach(System.out::println);
    }

}
