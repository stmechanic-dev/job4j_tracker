package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item curDate = new Item();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
//        String currentDateTimeFormat = curDate.getCreated().format(formatter);
//        System.out.println(currentDateTimeFormat);
        System.out.println(curDate);
    }
}
