package ru.job4j.tracker.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public static List<Address> collect(List<Profile> profiles) {
        List<Address> list = profiles.stream()
                            .map(addr -> addr.address)
                            .collect(Collectors.toList());

        return list;
    }
}
