package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idEnter = input.askInt("Enter Item id: ");
        if (tracker.delete(idEnter)) {
            out.println("Operation completed");
        } else {
            out.println("Operation failed");
        }
        return true;
    }
}
