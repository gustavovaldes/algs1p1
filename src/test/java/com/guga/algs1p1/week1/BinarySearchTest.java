package com.guga.algs1p1.week1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guga
 */
public class BinarySearchTest {

    @Test
    public void test(){
        int[] array = new int[]{1,3, 5, 7, 9, 11, 15};
        BinarySearch b  = new BinarySearch(array);
        Assert.assertEquals(2,b.find(5));
        Assert.assertEquals(-1,b.find(10));
    }
}
