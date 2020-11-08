package ru.job4j.tracker.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfileTest {
    @Test
    public void whenAdressCollect() {
        List<Profile> prof = Arrays.asList(new Profile(
                            new Address("Balashikha", "Lenina", 5, 4))
                , new Profile(new Address("Bryansk", "Pushkina", 7, 2)));
        List<Address> result = Profile.collect(prof);
        List<Address> expexted = Arrays.asList
                (new Address("Balashikha", "Lenina", 5, 4)
                 , new Address("Bryansk", "Pushkina", 7, 2));
        assertThat(result, is(expexted));
    }
}