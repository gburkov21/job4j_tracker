package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distance() {
        double expected = 2.0;
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double rsl = a.distance(b);
        Assert.assertEquals(rsl, expected, 0.01);
    }

    @Test
    public void distance3d() {
        double expected = 4.0;
        Point a = new Point(2, 2);
        Point b = new Point(2, 6);
        double rsl = a.distance(b);
        Assert.assertEquals(rsl, expected, 0.01);
    }
}