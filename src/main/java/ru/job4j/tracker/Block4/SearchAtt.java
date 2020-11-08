package ru.job4j.tracker.Block4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = filter(list, x -> x.getSize() > 100);
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = filter(list, x -> x.getName().contains("bug"));
        return rsl;
    }

    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = list.stream()
                                .filter(predicate)
                                .collect(Collectors.toList());
        return rsl;
    }
}