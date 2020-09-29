package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find Item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idEnter = input.askInt("Enter Item id: ");
        Item fById = tracker.findById(idEnter);
        if (fById != null) {
            System.out.println(fById);
        } else {
            System.out.println("Item with this id not found");
        }
        return true;
    }
}
