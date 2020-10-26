package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortMaxToMinTest {
    @Test
    public void whenSort() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(2, "b"));
        list.add(new Item(3, "c"));
        list.add(new Item(1, "a"));
        List<Item> expected = Arrays.asList(list.get(1), list.get(0), list.get(2));
        SortMaxToMin.sort(list);
        assertThat(list, is(expected));
    }
}