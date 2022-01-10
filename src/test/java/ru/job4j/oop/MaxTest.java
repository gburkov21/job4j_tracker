package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenMax1To2Then2() {
        int left = 1;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 2;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax3To4To5Then5() {
        int first = 3;
        int second = 4;
        int third = 5;
        int result = Max.max(first, second, third);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax6To7To8To9Then9() {
        int first = 6;
        int second = 7;
        int third = 8;
        int fourth = 9;
        int result = Max.max(first, second, third, fourth);
        int expected = 9;
        Assert.assertEquals(result, expected);
    }
}