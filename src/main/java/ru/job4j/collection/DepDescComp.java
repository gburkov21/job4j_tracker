package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] firstArray = o1.split("/");
        String[] secondArray = o2.split("/");

        int length = Math.min(firstArray.length, secondArray.length);
        int compareFirstElements = secondArray[0].compareTo(firstArray[0]);
        if (compareFirstElements == 0) {
            for (int i = 1; i < length; i++) {
                int compareNextElements = firstArray[i].compareTo(secondArray[i]);
                if (compareNextElements != 0) {
                    return compareNextElements;
                }
            }
            return o1.compareTo(o2);
        } else {
            return compareFirstElements;
        }
    }
}
