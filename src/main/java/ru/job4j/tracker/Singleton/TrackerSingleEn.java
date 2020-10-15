package ru.job4j.tracker.Singleton;

import ru.job4j.tracker.Tracker;

public enum TrackerSingleEn {
    INSTANCE;
    private Tracker tracker = new Tracker();

    public Tracker getInstance() {
        return tracker;
    }
}
