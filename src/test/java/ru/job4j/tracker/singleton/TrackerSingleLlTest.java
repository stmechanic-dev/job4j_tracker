package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingleLlTest {
    @Test
    public void whenStEn() {
        TrackerSingleLl first = TrackerSingleLl.getTracker();
        TrackerSingleLl second = TrackerSingleLl.getTracker();
        assertThat(first, is(second));
    }
}