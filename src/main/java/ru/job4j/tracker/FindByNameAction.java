package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find Item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String fByName = input.askStr("Enter Item name: ");
        Item[] list = tracker.findByName(fByName);
        if (list.length > 0) {
            for (Item i : list) {
                System.out.println(i);
            }
        } else {
            System.out.println("Items with this name not found");
        }
        return true;
    }
}
