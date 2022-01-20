package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void whenSortByNameDesc() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Armageddon"));
        items.add(new Item(2, "Tiger"));
        items.add(new Item(3, "Nokia"));

        Collections.sort(items, new ItemDescByName());
        List<Item> expected = List.of(new Item(2, "Tiger"), new Item(3, "Nokia"), new Item(1, "Armageddon"));
        assertEquals(expected, items);
    }
}