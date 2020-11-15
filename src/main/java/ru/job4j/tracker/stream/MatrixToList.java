package ru.job4j.tracker.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    public static List<Integer> coverterMatrToList(Integer[][] matrix) {
        List<Integer> list = Stream.of(matrix).flatMap(Stream::of)
                            .collect(Collectors.toList());
        return list;
    }
}
