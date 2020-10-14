package ru.job4j.tracker.Singleton;

public class TrackerSingleEl {
    private static final TrackerSingleEl tracker = new TrackerSingleEl();

    private TrackerSingleEl() {
    }

    public static TrackerSingleEl getTracker() {
        return tracker;
    }
}
