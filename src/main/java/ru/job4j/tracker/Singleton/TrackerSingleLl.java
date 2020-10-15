package ru.job4j.tracker.Singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingleLl {
    private Tracker instance = new Tracker();

    public Tracker getInstance() {
        return instance;
    }

    private TrackerSingleLl() {
    }

    public static TrackerSingleLl getTracker() {
        return Holder.tracker;
    }

    public static final class Holder {
        private static final TrackerSingleLl tracker = new TrackerSingleLl();
    }
}
