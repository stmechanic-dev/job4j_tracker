package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingleEl {
    private static final TrackerSingleEl TRACKER = new TrackerSingleEl();
    private Tracker instance = new Tracker();

    public Tracker getInstance() {
        return instance;
    }

    public static TrackerSingleEl getTracker() {
        return TRACKER;
    }
}
