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
        list.add(new Item(2,"b"));
        list.add(new Item(3,"c"));
        list.add(new Item(1,"a"));
        SortMaxToMin.sort(list);
        String s = list.toString();
        String expected = "[Item{id = 3, name = 'c'}, Item{id = 2, name = 'b'}, Item{id = 1, name = 'a'}]";
        assertThat(s, is(expected));
    }
}