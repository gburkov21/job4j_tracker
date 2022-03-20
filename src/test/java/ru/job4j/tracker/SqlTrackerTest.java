package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker();
        tracker.setCn(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplaceThenFindSecondItemName() {
        SqlTracker tracker = new SqlTracker();
        tracker.setCn(connection);
        Item item = tracker.add(new Item("item"));
        Item replacedItem = new Item("superItem");
        tracker.replace(item.getId(), replacedItem);
        assertThat(tracker.findById(item.getId()).getName(), is("superItem"));
    }

    @Test
    public void whenDeleteItemThenSizeDecrease() {
        SqlTracker tracker = new SqlTracker();
        tracker.setCn(connection);
        Item item = tracker.add(new Item("item"));
        Item secondItem = tracker.add(new Item("superItem"));
        assertThat(tracker.findAll(), is(List.of(item, secondItem)));
        assertThat(tracker.delete(item.getId()), is(true));
        assertThat(tracker.findAll(), is(List.of(secondItem)));
        assertThat(tracker.delete(secondItem.getId()), is(true));
        assertThat(tracker.findAll(), is(empty()));
    }

    @Test
    public void whenAddItemsThenSizeIncrease() {
        SqlTracker tracker = new SqlTracker();
        tracker.setCn(connection);

        assertThat(tracker.findAll(), is(empty()));
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findAll(), is(List.of(item)));
        Item secondItem = tracker.add(new Item("second"));
        assertThat(tracker.findAll(), is(List.of(item, secondItem)));
        Item thirdItem = tracker.add(new Item("third"));
        assertThat(tracker.findAll(), is(List.of(item, secondItem, thirdItem)));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker();
        tracker.setCn(connection);
        Item item = tracker.add(new Item("item"));
        Item secondItem = tracker.add(new Item("secondItem"));
        assertThat(tracker.findByName(item.getName()).get(0).getName(), is("item"));
        assertThat(tracker.findByName(secondItem.getName()).get(0).getName(), is("secondItem"));
    }

}