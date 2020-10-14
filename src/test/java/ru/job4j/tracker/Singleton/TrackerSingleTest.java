package ru.job4j.tracker.Singleton;

import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingleTest {
    @Test
    public void whenSt() {
        TrackerSingle first = TrackerSingle.getTracker();
        TrackerSingle second = TrackerSingle.getTracker();
        assertThat(first, is(second));
    }
}