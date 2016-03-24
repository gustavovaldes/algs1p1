package com.guga.algs1p1.week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gvaldes
 */
public class BSTTest {

    @Test
    public void test() {
        BST<Character, Integer> bst = new BST<>();
        bst.put('M', 1);
        bst.put('A', 2);
        bst.put('X', 3);
        bst.put('E', 4);

        Assert.assertEquals(4, bst.size());
        Assert.assertEquals(1, (int) bst.get('M'));
        Assert.assertEquals(2, (int) bst.get('A'));
        Assert.assertEquals(3, (int) bst.get('X'));
        Assert.assertEquals(4, (int) bst.get('E'));
        Assert.assertNull(bst.get('D'));

    }


    @Test
    public void testFloor() {
        BST<Character, Integer> bst = new BST<>();
        bst.put('M', 1);
        bst.put('B', 2);
        bst.put('X', 3);
        bst.put('E', 4);
        bst.put('G', 5);
        bst.put('D', 6);

        Assert.assertEquals("X", "" + bst.floor('X'));
        Assert.assertEquals("E", "" + bst.floor('F'));
        Assert.assertEquals("B", "" + bst.floor('B'));
        Assert.assertEquals("X", "" + bst.floor('Y'));
        Assert.assertNull(bst.floor('A'));
    }


    @Test
    public void testCeiling() {
        BST<Character, Integer> bst = new BST<>();
        bst.put('M', 1);
        bst.put('B', 2);
        bst.put('X', 3);
        bst.put('E', 4);
        bst.put('G', 5);
        bst.put('D', 6);

        Assert.assertEquals("X", "" + bst.ceiling('X'));
        Assert.assertEquals("G", "" + bst.ceiling('F'));
        Assert.assertEquals("B", "" + bst.ceiling('B'));
        Assert.assertNull(bst.ceiling('Y'));
        Assert.assertEquals("B", "" + bst.ceiling('A'));
        Assert.assertNull( bst.ceiling('Z'));
    }
}
