package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    static Connection connection;

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
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenReplaceThenFindSecondItemName() {
        SqlTracker tracker = new SqlTracker();
        tracker.setCn(connection);
        Item item = new Item("item");
        Item replacedItem = new Item("superItem");
        tracker.add(item);
        tracker.replace(item.getId(), replacedItem);
        assertThat(tracker.findById(item.getId()).getName(), is("superItem"));
    }

    @Test
    public void whenDeleteItemThenSizeDecrease() {
        SqlTracker tracker = new SqlTracker();
        tracker.setCn(connection);
        Item item = new Item("item");
        Item secondItem = new Item("superItem");
        tracker.add(item);
        tracker.add(secondItem);
        assertThat(tracker.findAll().size(), is(2));
        assertThat(tracker.delete(item.getId()), is(true));
        assertThat(tracker.findAll().size(), is(1));
        assertThat(tracker.delete(secondItem.getId()), is(true));
        assertThat(tracker.findAll().size(), is(0));
    }

    @Test
    public void whenAddItemsThenSizeIncrease() {
        SqlTracker tracker = new SqlTracker();
        tracker.setCn(connection);
        Item item = new Item("item");
        Item secondItem = new Item("second");
        Item thirdItem = new Item("third");

        assertThat(tracker.findAll().size(), is(0));
        tracker.add(item);
        assertThat(tracker.findAll().size(), is(1));
        tracker.add(secondItem);
        assertThat(tracker.findAll().size(), is(2));
        tracker.add(thirdItem);
        assertThat(tracker.findAll().size(), is(3));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker();
        tracker.setCn(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findByName(item.getName()).get(0).getName(), is("item"));
    }

}