package ru.job4j.tracker.stream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> list = students.stream()
                            .filter(predict)
                            .collect(Collectors.toList());
        return list;
    }

    public Map<String, Student> collectToMap(List<Student> students) {
        Map<String, Student> map = students.stream().collect
                (Collectors.toMap(
                      Student::getSurname,
                      Function.identity(),
                        (x, replacement) -> x));
        return map;
    }
}
