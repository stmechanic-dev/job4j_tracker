package ru.job4j.tracker.Singleton;

public class TrackerSingle {
    private static TrackerSingle tracker;

    private TrackerSingle() {
    }

    public static TrackerSingle getTracker() {
        if (tracker == null) {
            tracker = new TrackerSingle();
        }
        return tracker;
    }
}
