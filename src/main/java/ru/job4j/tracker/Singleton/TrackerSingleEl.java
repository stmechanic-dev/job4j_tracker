package ru.job4j.tracker.Singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingleEl {
    private static final TrackerSingleEl tracker = new TrackerSingleEl();
    private Tracker instance = new Tracker();

    public Tracker getInstance() {
        return instance;
    }

    private TrackerSingleEl() {
    }

    public static TrackerSingleEl getTracker() {
        return tracker;
    }
}
