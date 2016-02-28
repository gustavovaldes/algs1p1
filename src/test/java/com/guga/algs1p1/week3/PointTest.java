package com.guga.algs1p1.week3;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by guga
 */
public class PointTest {


    @Test
    public void testSlope() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(1, 2);
        Point p4 = new Point(2, 1);
        Assert.assertEquals(1d, p1.slopeTo(p2), 0d);
        Assert.assertEquals(Double.POSITIVE_INFINITY, p2.slopeTo(p3), 0d);
        Assert.assertEquals(0d, p2.slopeTo(p4), 0d);
        Assert.assertEquals(-1d, p3.slopeTo(p4), 0d);
        Assert.assertEquals(Double.NEGATIVE_INFINITY, p4.slopeTo(p4), 0d);
    }


    @Test
    public void testCompare() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 1);
        Point p3 = new Point(-1, -2);
        Point p4 = new Point(-3, 2);
        Point p5 = new Point(1, 2);

        Assert.assertEquals(0, p1.compareTo(p1)); //0
        Assert.assertEquals(1, p1.compareTo(p2)); //1
        Assert.assertEquals(1, p1.compareTo(p3)); //1
        Assert.assertEquals(1, p1.compareTo(p4)); //1
        Assert.assertEquals(0, p1.compareTo(p5)); //0
        Assert.assertEquals(0, p2.compareTo(p2)); //0
        Assert.assertEquals(-1, p2.compareTo(p1)); //-1


    }

    @Test
    public void testOrder() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(1, 2);
        Point p4 = new Point(2, 1);
        Point p5 = new Point(-1, -2);
        Point p6 = new Point(-3, 2);
        Point p7 = new Point(1, 2);
        Point[] values = new Point[]{p1, p2, p3, p4, p5, p6, p7};
        Arrays.sort(values);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].draw();
        }
    }
}
