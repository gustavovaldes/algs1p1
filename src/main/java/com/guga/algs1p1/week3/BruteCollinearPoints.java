package com.guga.algs1p1.week3;

import java.util.*;

/**
 * Created by guga
 * <p>
 * Brute force implementation
 */
public class BruteCollinearPoints {
    private List<LineSegment> lineSegments;

    public BruteCollinearPoints(Point[] points) {  // finds all line segments containing 4 points
        lineSegments = new ArrayList<>();
        if (points == null) throw new NullPointerException();
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    double s = points[i].slopeTo(points[j]);
                    if(s == Double.NEGATIVE_INFINITY) throw  new IllegalArgumentException();//duplicated point
                    if (s == points[i].slopeTo(points[k])) {
                        for (int l = k + 1; l < points.length; l++) {
                            if (s == points[i].slopeTo(points[l])) {
                                lineSegments.add(extractSegment(points[i],
                                        points[j], points[k], points[l]));
                            }
                        }
                    }
                }
            }
        }
    }

    private LineSegment extractSegment(Point p1, Point p2, Point p3, Point p4) {
        Point[] val = new Point[]{p1, p2, p3, p4};
        Arrays.sort(val);
        return new LineSegment(val[0], val[3]);
    }


    public int numberOfSegments() { // the number of line segments
        return lineSegments.size();
    }

    public LineSegment[] segments() {   // the line segments
        LineSegment[] result = new LineSegment[lineSegments.size()];
        lineSegments.toArray(result);
        return result;
    }
}
