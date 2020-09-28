package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All Items List ===");
                Item[] listAll = tracker.findAll();
                for (Item i : listAll) {
                    System.out.println(i);
                }
            } else if (select == 2) {
                System.out.println("=== Replace Item ===");
                System.out.println("Enter Item id: ");
                int idEnter = Integer.valueOf(scanner.nextLine());
                System.out.println("Enter new disctription: ");
                String newName = scanner.nextLine();
                Item replItem = new Item();
                replItem.setName(newName);
                if (tracker.replace(idEnter, replItem)) {
                    System.out.println("Operation completed");
                } else {
                    System.out.println("Operation failed");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ===");
                System.out.println("Enter Item id: ");
                int idEnter = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(idEnter)) {
                    System.out.println("Operation completed");
                } else {
                    System.out.println("Operation failed");
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by id ===");
                System.out.println("Enter Item id: ");
                int idEnter = Integer.valueOf(scanner.nextLine());
                Item fById = tracker.findById(idEnter);
                if (fById != null) {
                    System.out.println(fById);
                } else {
                    System.out.println("Item with this id not found");
                }
            } else if (select == 5) {
                System.out.println("=== Find Item by name ===");
                System.out.println("Enter Item name: ");
                String fByName = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
