package com.guga.algs1p1.week3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guga
 */
public class FastCollinearPointsTest {

    private Point[] readPoints(String file) {
        In in = new In(file);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }
        return points;
    }


    @Test
    public void test10() {
        Point[] points = readPoints("/week3/input10.txt");
        LineSegment[] segments = new FastCollinearPoints(points).segments();
        for (LineSegment segment : segments) {
            System.out.println(segment);
        }
        Assert.assertEquals(2, segments.length);
        Assert.assertEquals("(1000, 18000) -> (4000, 30000)", segments[0].toString());
        Assert.assertEquals("(28000, 13500) -> (3000, 26000)", segments[1].toString());
    }

    @Test
    public void test9() {
        Point[] points = readPoints("/week3/input9.txt");
        LineSegment[] segments = new FastCollinearPoints(points).segments();
        for (LineSegment segment : segments) {
            System.out.println(segment);
        }
        Assert.assertEquals(1, segments.length);
        Assert.assertEquals("(1000, 1000) -> (9000, 9000)", segments[0].toString());
    }

    @Test
    public void testVertical5() {
        Point[] points = readPoints("/week3/vertical5.txt");
        LineSegment[] segments = new FastCollinearPoints(points).segments();
        Assert.assertEquals(5, segments.length);
        Assert.assertEquals("(14407, 10367) -> (14407, 19953)", segments[0].toString());
        Assert.assertEquals("(15976, 3370) -> (15976, 9945)", segments[1].toString());
        Assert.assertEquals("(2088, 6070) -> (2088, 16387)", segments[2].toString());
        Assert.assertEquals("(5757, 3426) -> (5757, 20856)", segments[3].toString());
        Assert.assertEquals("(8421, 1829) -> (8421, 18715)", segments[4].toString());

    }

    @Test
    public void test40() {
        Point[] points = readPoints("/week3/input40.txt");
        LineSegment[] segments = new FastCollinearPoints(points).segments();
        Assert.assertEquals(4, segments.length);
        Assert.assertEquals("(1000, 17000) -> (29000, 17000)", segments[0].toString());
        Assert.assertEquals("(1000, 17000) -> (1000, 31000)", segments[1].toString());
        Assert.assertEquals("(2000, 24000) -> (25000, 24000)", segments[2].toString());
        Assert.assertEquals("(2000, 29000) -> (28000, 29000)", segments[3].toString());
    }

    @Test
    public void test400() {
        Point[] points = readPoints("/week3/input400.txt");
        LineSegment[] segments = new FastCollinearPoints(points).segments();
        /*for (LineSegment segment : segments) {
            System.out.println(segment);
        }*/
        Assert.assertEquals(7, segments.length);
        Assert.assertEquals("(18150, 7150) -> (11250, 20950)", segments[0].toString());
        Assert.assertEquals("(16450, 10750) -> (23200, 10750)", segments[1].toString());
        Assert.assertEquals("(20950, 9500) -> (20950, 28700)", segments[2].toString());
        Assert.assertEquals("(27400, 24750) -> (21900, 25250)", segments[3].toString());
        Assert.assertEquals("(16050, 950) -> (1050, 15950)", segments[4].toString());
        Assert.assertEquals("(29100, 24300) -> (18900, 26000)", segments[5].toString());
        Assert.assertEquals("(26000, 8900) -> (15250, 28250)", segments[6].toString());

    }

    @Test
    public void test() {

        // read the N points from a file
        In in = new In("/week3/rs1423.txt");
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.show(0);
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
        System.out.println();
    }
}
