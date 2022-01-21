package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        char[] firstArray = o1.toCharArray();
        char[] secondArray = o2.toCharArray();
        int length = Math.min(firstArray.length, secondArray.length);
        for (int i = 0; i < length; i++) {
            if (firstArray[i] != secondArray[i]) {
                return Integer.compare(firstArray[i], secondArray[i]);
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}
