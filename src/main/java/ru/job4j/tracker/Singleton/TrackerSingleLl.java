package ru.job4j.tracker.Singleton;

public class TrackerSingleLl {
    private TrackerSingleLl() {
    }

    public static TrackerSingleLl getTracker() {
        return Holder.tracker;
    }

    public static final class Holder {
        private static final TrackerSingleLl tracker = new TrackerSingleLl();
    }
}
