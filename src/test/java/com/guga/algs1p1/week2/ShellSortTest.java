package com.guga.algs1p1.week2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guga
 */
public class ShellSortTest {

    @Test
    public void testEmpty() {
        Integer[] values = new Integer[0];
        ShellSort.sort(values);
        Assert.assertNotNull(values);
    }

    @Test
    public void testOneElement() {
        Integer[] values = new Integer[]{1};
        ShellSort.sort(values);
        Assert.assertEquals(1, (int) values[0]);
    }

    @Test
    public void testTwoElement() {
        Integer[] values = new Integer[]{4, 1};
        ShellSort.sort(values);
        Assert.assertEquals(1, (int) values[0]);
        Assert.assertEquals(4, (int) values[1]);
    }

    @Test
    public void testOrder() {
        Integer[] values = new Integer[]{8, 2, 5, 3, 9, 4, 0, 2, -1, -3, 6, 8};
        Integer[] expected = new Integer[]{-3, -1, 0, 2, 2, 3, 4, 5, 6, 8, 8, 9};
        ShellSort.sort(values);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], values[i]);
        }
        ShellSort.sort(values);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], values[i]);
        }
    }

    @Test
    public void testOrdered() {
        Integer[] values = new Integer[]{-1, 4, 5, 8, 10, 42};
        Integer[] expected = new Integer[]{-1, 4, 5, 8, 10, 42};
        ShellSort.sort(values);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], values[i]);
        }
    }
}
