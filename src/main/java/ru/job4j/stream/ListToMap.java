package ru.job4j.stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ListToMap {
    public static Map<String, Student> convert(List<Student> list) {
        Map<String, Student> resultMap = list.stream()
                .collect(Collectors.toMap(
                        key -> key.getSurname(),
                        value -> value,
                        (firstStudent, secondStudent) -> firstStudent));
        return resultMap;
    }
}
