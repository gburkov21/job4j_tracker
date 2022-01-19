package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> mailToFioMap = new HashMap<>();
        mailToFioMap.put("ivan@mail.ru", "Иванов Иван Иванович");
        mailToFioMap.put("vasya@mail.ru", "Сидоров Василий Петрович");
        mailToFioMap.put("dima@mail.ru", "Фролов Дмитрий Николаевич");

        for (String key : mailToFioMap.keySet()) {
            System.out.println(key + " = " + mailToFioMap.get(key));
        }
    }
}
