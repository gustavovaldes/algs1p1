package com.guga.algs1p1.week1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guga
 */
public class QuickFindTest {

    @Test
    public void test(){
        QuickFind qf = new QuickFind(10);
        qf.union(0,2);
        qf.union(3,5);
        qf.union(6,7);
        qf.union(6,5);

        Assert.assertTrue(qf.connected(0,2));
        Assert.assertTrue(qf.connected(3,5));
        Assert.assertTrue(qf.connected(6,7));
        Assert.assertTrue(qf.connected(5,6));
        Assert.assertTrue(qf.connected(6,3));
        Assert.assertFalse(qf.connected(0,3));
        Assert.assertFalse(qf.connected(1,7));
        Assert.assertFalse(qf.connected(8,9));
    }
}
