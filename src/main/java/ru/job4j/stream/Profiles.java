package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .toList();
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        Comparator<Address> cityComparator = (firstAddress, secondAddress) -> firstAddress.getCity().compareTo(secondAddress.getCity());
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .sorted(cityComparator)
                .distinct()
                .toList();
    }
}