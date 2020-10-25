package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingleLl {
    private Tracker instance = new Tracker();

    public Tracker getInstance() {
        return instance;
    }

    public static TrackerSingleLl getTracker() {
        return Holder.TRACKER;
    }

    public static final class Holder {
        private static final TrackerSingleLl TRACKER = new TrackerSingleLl();
    }
}
