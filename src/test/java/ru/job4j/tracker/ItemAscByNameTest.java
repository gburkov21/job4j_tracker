package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void whenSortByNameAsc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Zero"));
        items.add(new Item(2, "Alpha"));
        items.add(new Item(3, "Native"));

        Collections.sort(items, new ItemAscByName());
        List<Item> expected = List.of(new Item(2, "Alpha"), new Item(3, "Native"), new Item(1, "Zero"));
        assertEquals(expected, items);
    }
}