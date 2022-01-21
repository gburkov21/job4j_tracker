package ru.job4j.collection;

import java.util.*;

public class Departments {
    private static List<String> departments = Arrays.asList(
            "K1",
            "K1/SK1",
            "K1/SK1/SSK1",
            "K1/SK1/SSK2",
            "K1/SK2",
            "K2",
            "K2/SK1",
            "K2/SK1/SSK1",
            "K2/SK1/SSK2"
    );

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start.isBlank()) {
                    start = el;
                    tmp.add(start);
                } else {
                    start = start + "/" + el;
                    tmp.add(start);
                }
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}
