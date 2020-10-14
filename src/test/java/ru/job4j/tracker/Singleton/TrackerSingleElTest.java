package ru.job4j.tracker.Singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingleElTest {
    @Test
    public void whenStEn() {
        TrackerSingleEl first = TrackerSingleEl.getTracker();
        TrackerSingleEl second = TrackerSingleEl.getTracker();
        assertThat(first, is(second));
    }
}