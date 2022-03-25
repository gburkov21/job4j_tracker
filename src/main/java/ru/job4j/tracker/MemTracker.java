package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        int index = 0;
        for (Item item : items) {
            if (key.equals(item.getName())) {
                result.add(item);
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            Item item = items.get(index);
            if (item.getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public static void addItems(MemTracker tracker) {
        for (int i = 0; i < 100_000; i++) {
            tracker.add(new Item(i, "Item #" + i, LocalDateTime.now()));
        }
    }

    public static void deleteItems(MemTracker tracker) {
        for (int i = 0; i < 100_000; i++) {
            tracker.delete(i);
        }
    }

    public static void main(String[] args) {
        MemTracker tracker = new MemTracker();
        addItems(tracker);
        deleteItems(tracker);
    }
}