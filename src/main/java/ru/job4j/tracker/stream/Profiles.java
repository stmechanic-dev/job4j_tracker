package ru.job4j.tracker.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        List<Address> list = profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());

        return list;
    }
}
