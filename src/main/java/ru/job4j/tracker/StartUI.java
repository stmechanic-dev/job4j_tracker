package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.itemList(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void itemList(Tracker tracker) {
        System.out.println("=== All Items List ===");
        Item[] listAll = tracker.findAll();
        for (Item i : listAll) {
            System.out.println(i);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Replace Item ===");
        int idEnter = input.askInt("Enter Item id: ");
        String newName = input.askStr("Enter new disctription: ");
        Item replItem = new Item(newName);
        if (tracker.replace(idEnter, replItem)) {
            System.out.println("Operation completed");
        } else {
            System.out.println("Operation failed");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ===");
        int idEnter = input.askInt("Enter Item id: ");
        if (tracker.delete(idEnter)) {
            System.out.println("Operation completed");
        } else {
            System.out.println("Operation failed");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find Item by id ===");
        int idEnter = input.askInt("Enter Item id: ");
        Item fById = tracker.findById(idEnter);
        if (fById != null) {
            System.out.println(fById);
        } else {
            System.out.println("Item with this id not found");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find Item by name ===");
        String fByName = input.askStr("Enter Item name: ");
        Item[] list = tracker.findByName(fByName);
        if (list.length > 0) {
            for (Item i : list) {
                System.out.println(i);
            }
        } else {
            System.out.println("Items with this name not found");
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
