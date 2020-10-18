package ru.job4j.tracker;

import java.util.ArrayList;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String fByName = input.askStr("Enter Item name: ");
        ArrayList<Item> list = tracker.findByName(fByName);
        if (list.size() > 0) {
            for (Item i : list) {
                out.println(i);
            }
        } else {
            out.println("Items with this name not found");
        }
        return true;
    }
}
