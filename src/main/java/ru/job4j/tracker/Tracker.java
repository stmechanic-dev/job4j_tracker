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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] list = new Item[this.size];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
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

    public boolean delete(int id) {
        boolean rsl = false;
        int itemsId = indexOf(id);
        if (itemsId != -1) {
            System.arraycopy(items, itemsId + 1, items,
                    itemsId, size - itemsId);
            items[size - 1] = null;
            size--;
            rsl = true;
        }
        return rsl;
    }
}