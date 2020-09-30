package ru.job4j.tracker;

public class ListAction implements UserAction {
    private final Output out;

    public ListAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "All Items List";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] listAll = tracker.findAll();
        for (Item i : listAll) {
            out.println(i);
        }
        return true;
    }
}
