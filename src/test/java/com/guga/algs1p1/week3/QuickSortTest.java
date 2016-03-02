package com.guga.algs1p1.week3;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guga
 */
public class QuickSortTest {

    @Test
    public void testSort() {
        Integer[] values = new Integer[]{1, 3, 7, 2, 4, 6, 9};
        Integer[] result = new Integer[]{1, 2, 3, 4, 6, 7, 9};
        QuickSort.sort(values);
        for (int i = 0; i < result.length; i++) {
            Assert.assertEquals(values[i],result[i]);
        }
    }

    @Test
    public void testEmpty() {
        Integer[] values = new Integer[0];
        QuickSort.sort(values);
        Assert.assertNotNull(values);
    }

    @Test
    public void testOneElement() {
        Integer[] values = new Integer[]{1};
        QuickSort.sort(values);
        Assert.assertEquals(1, (int) values[0]);
    }

    @Test
    public void testTwoElement() {
        Integer[] values = new Integer[]{4, 1};
        QuickSort.sort(values);
        Assert.assertEquals(1, (int) values[0]);
        Assert.assertEquals(4, (int) values[1]);
    }

    @Test
    public void testDoubleSort() {
        Integer[] values = new Integer[]{8, 2, 5, 3, 9, 4, 0, 2, -1, -3, 6, 8};
        Integer[] expected = new Integer[]{-3, -1, 0, 2, 2, 3, 4, 5, 6, 8, 8, 9};
        QuickSort.sort(values);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], values[i]);
        }
        QuickSort.sort(values);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], values[i]);
        }
    }

    @Test
    public void testAlreadyOrdered() {
        Integer[] values = new Integer[]{-1, 4, 5, 8, 10, 42};
        Integer[] expected = new Integer[]{-1, 4, 5, 8, 10, 42};
        QuickSort.sort(values);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(expected[i], values[i]);
        }
    }
}
