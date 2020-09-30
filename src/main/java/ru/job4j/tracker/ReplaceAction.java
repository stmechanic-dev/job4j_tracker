package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idEnter = input.askInt("Enter Item id: ");
        String newName = input.askStr("Enter new disctription: ");
        Item replItem = new Item(newName);
        if (tracker.replace(idEnter, replItem)) {
            System.out.println("Operation completed");
        } else {
            System.out.println("Operation failed");
        }
        return true;
    }
}
