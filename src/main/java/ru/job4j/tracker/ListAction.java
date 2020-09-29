package ru.job4j.tracker;

public class ListAction implements UserAction {
    @Override
    public String name() {
        return "All Items List";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] listAll = tracker.findAll();
        for (Item i : listAll) {
            System.out.println(i);
        }
        return true;
    }
}
