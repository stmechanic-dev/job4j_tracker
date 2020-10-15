package ru.job4j.tracker.Singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingle {
    private static TrackerSingle tracker;
    private Tracker instance = new Tracker();

    public Tracker getInstance() {
        return instance;
    }

    private TrackerSingle() {
    }

    public static TrackerSingle getTracker() {
        if (tracker == null) {
            tracker = new TrackerSingle();
        }
        return tracker;
    }
}
