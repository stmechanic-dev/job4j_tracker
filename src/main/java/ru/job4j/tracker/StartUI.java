package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                String name = input.askStr("=== Create a new Item ====" + System.lineSeparator()
                                                        + "Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All Items List ===");
                Item[] listAll = tracker.findAll();
                for (Item i : listAll) {
                    System.out.println(i);
                }
            } else if (select == 2) {
                int idEnter = input.askInt("=== Replace Item ===" + System.lineSeparator()
                                                        + "Enter Item id: ");
                String newName = input.askStr("Enter new disctription: ");
                Item replItem = new Item(newName);
                if (tracker.replace(idEnter, replItem)) {
                    System.out.println("Operation completed");
                } else {
                    System.out.println("Operation failed");
                }
            } else if (select == 3) {
                int idEnter = input.askInt("=== Delete Item ===" + System.lineSeparator()
                                                    + "Enter Item id: ");
                if (tracker.delete(idEnter)) {
                    System.out.println("Operation completed");
                } else {
                    System.out.println("Operation failed");
                }
            } else if (select == 4) {
                int idEnter = input.askInt("=== Find Item by id ===" + System.lineSeparator()
                                                        + "Enter Item id: ");
                Item fById = tracker.findById(idEnter);
                if (fById != null) {
                    System.out.println(fById);
                } else {
                    System.out.println("Item with this id not found");
                }
            } else if (select == 5) {
                System.out.println();
                System.out.println();
                String fByName = input.askStr("=== Find Item by name ===" + System.lineSeparator()
                                                            + "Enter Item name: ");
                Item[] list = tracker.findByName(fByName);
                if (list.length > 0) {
                    for (Item i : list) {
                        System.out.println(i);
                    }
                } else {
                    System.out.println("Items with this name not found");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
