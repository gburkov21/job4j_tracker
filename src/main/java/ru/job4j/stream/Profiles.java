package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress()).toList();
    }
}
