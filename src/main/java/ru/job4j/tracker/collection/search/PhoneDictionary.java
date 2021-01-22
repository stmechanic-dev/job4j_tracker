package ru.job4j.tracker.collection.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combineName = x -> x.getName().contains(key);
        Predicate<Person> combineSurName = x -> x.getSurname().contains(key);
        Predicate<Person> combinePhoneNumb = x -> x.getPhone().contains(key);
        Predicate<Person> combineAddress = x -> x.getAddress().contains(key);
        Predicate<Person> combine = combineName.or(combineSurName)
                .or(combinePhoneNumb).or(combineAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
