package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> namePredicate = person -> person.getName().contains(key);
        Predicate<Person> surNamePredicate = person -> person.getSurname().contains(key);
        Predicate<Person> addressPredicate = person -> person.getAddress().contains(key);
        Predicate<Person> phonePredicate = person -> person.getPhone().contains(key);
        Predicate<Person> combine = namePredicate.or(surNamePredicate).or(addressPredicate).or(phonePredicate);

        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
