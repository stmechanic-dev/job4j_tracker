package ru.job4j.tracker.Singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleEnTest {
    @Test
    public void whenStEn() {
        TrackerSingleEn first = TrackerSingleEn.INSTANCE;
        TrackerSingleEn second = TrackerSingleEn.INSTANCE;
        assertThat(first, is(second));
    }

}