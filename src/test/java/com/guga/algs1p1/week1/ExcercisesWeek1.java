package com.guga.algs1p1.week1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guga
 */
public class ExcercisesWeek1 {

    @Test
    public void question1() {
        QuickFind qf = new QuickFind(10);
        qf.union(1, 3);
        qf.union(3, 5);
        qf.union(2, 6);
        qf.union(1, 9);
        qf.union(4, 9);
        qf.union(3, 0);
        int[] values = qf.getValues();
        /*for (int i = 0; i < 10; i++) {
            System.out.print(values[i] + " ");
        }*/
        Assert.assertEquals(0,values[0]);
        Assert.assertEquals(0,values[1]);
        Assert.assertEquals(6,values[2]);
        Assert.assertEquals(0,values[3]);
        Assert.assertEquals(0,values[4]);
        Assert.assertEquals(0,values[5]);
        Assert.assertEquals(6,values[6]);
        Assert.assertEquals(7,values[7]);
        Assert.assertEquals(8,values[8]);
        Assert.assertEquals(0,values[9]);

    }

    @Test
    public void question2() {
        WeightedQuickUnion qu = new WeightedQuickUnion(10);
        qu.union(7, 8);
        qu.union(5, 9);
        qu.union(4, 1);
        qu.union(6, 1);
        qu.union(6, 0);
        qu.union(2, 0);
        qu.union(7, 5);
        qu.union(9, 6);
        qu.union(1, 3);
        int[] values = qu.getValues();
        /*for (int i = 0; i < 10; i++) {
            System.out.print(values[i] + " ");
        }*/
        Assert.assertEquals(4,values[0]);
        Assert.assertEquals(4,values[1]);
        Assert.assertEquals(4,values[2]);
        Assert.assertEquals(4,values[3]);
        Assert.assertEquals(4,values[4]);
        Assert.assertEquals(7,values[5]);
        Assert.assertEquals(4,values[6]);
        Assert.assertEquals(4,values[7]);
        Assert.assertEquals(7,values[8]);
        Assert.assertEquals(5,values[9]);
    }
}
