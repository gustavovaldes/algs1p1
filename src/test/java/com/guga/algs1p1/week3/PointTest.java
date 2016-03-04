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
        Assert.assertEquals(0d, p2.slopeTo(p3), 0d);
        Assert.assertEquals(Double.POSITIVE_INFINITY, p2.slopeTo(p4), 0d);
        Assert.assertEquals(-1d, p3.slopeTo(p4), 0d);
        Assert.assertEquals(Double.NEGATIVE_INFINITY, p4.slopeTo(p4), 0d);

        Point p             = new Point(251, 60);
        Point q             = new Point(251, 443);
        System.out.println(p.slopeTo(q));

        Point r             = new Point(0, 6);
        Point s             = new Point(0, 8);
        System.out.println(r.slopeTo(s));
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

    @Test
    public void testLine(){
        Point p1 = new Point(1,1);
        Point p2 = new Point(2,2);
        Point p3 = new Point(3,3);
        Point p4 = new Point(4,4);

        System.out.println(p1.slopeTo(p2));
        System.out.println(p1.slopeTo(p3));
        System.out.println(p2.slopeTo(p1));
        System.out.println(p3.slopeTo(p2));
        System.out.println(p4.slopeTo(p1));
        System.out.println(p1.slopeTo(p4));

        System.out.println("___");
        Point p11 = new Point(4000, 30000);
        Point p22 = new Point(3500, 28000);
        Point p33 = new Point(3000, 26000);

        System.out.println(p11.slopeTo(p22));
        System.out.println(p22.slopeTo(p11));
        System.out.println(p22.slopeTo(p33));
        System.out.println(p22.slopeTo(p22));

    }
}
