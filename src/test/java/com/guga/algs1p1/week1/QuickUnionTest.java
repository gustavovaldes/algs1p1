package com.guga.algs1p1.week1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guga
 */
public class QuickUnionTest {

    @Test
    public void test(){
        QuickUnion qu = new QuickUnion(10);
        qu.union(0,2);
        qu.union(3,5);
        qu.union(6,7);
        qu.union(6,5);

        Assert.assertTrue(qu.connected(0,2));
        Assert.assertTrue(qu.connected(3,5));
        Assert.assertTrue(qu.connected(6,7));
        Assert.assertTrue(qu.connected(5,6));
        Assert.assertTrue(qu.connected(6,3));
        Assert.assertFalse(qu.connected(0,3));
        Assert.assertFalse(qu.connected(1,7));
        Assert.assertFalse(qu.connected(8,9));
    }
}
