package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll(){
        Item[] list = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName() != null && items[i].getId() != 0) {
                list[size] = items[i];
                size++;
            }
        }
        list = Arrays.copyOf(list, size);
        return list;
    }

    public Item[] findByName(String key) {
        Item[] list = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(key)) {
                list[size] = items[i];
                size++;
            }
        }
        list = Arrays.copyOf(list, size);
        return list;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int itemsId = indexOf(id);
        if (itemsId != -1) {
            items[itemsId].setName(item.getName());
            rsl = true;
        }
        return rsl;
    }
}