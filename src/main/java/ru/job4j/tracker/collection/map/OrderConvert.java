package ru.job4j.tracker.collection.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderConvert {
    public static Map<String, Order> process(List<Order> orders) {
        Map<String, Order> map = new HashMap<>();
        for (Order o : orders) {
            map.put(o.getNumber(), o);
        }
        return map;
    }
}
