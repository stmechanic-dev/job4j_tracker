package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll(){
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(key)) {
                list.add(items.get(i));
            }
        }
        return list;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int itemsId = indexOf(id);
        if (itemsId != -1) {
            items.set(itemsId, item);
            items.get(itemsId).setId(id);
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int itemsId = indexOf(id);
        if (itemsId != -1) {
            items.remove(itemsId);
            rsl = true;
        }
        return rsl;
    }
}