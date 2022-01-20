package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        char[] firstArray;
        char[] secondArray;
        if (o1.length() < o2.length()) {
            firstArray = o1.toCharArray();
            secondArray = o2.toCharArray();
        } else {
            firstArray = o2.toCharArray();
            secondArray = o1.toCharArray();
        }
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]) {
                return Integer.compare(o1.charAt(i), o2.charAt(i));
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}