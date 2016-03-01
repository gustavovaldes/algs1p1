package com.guga.algs1p1.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guga
 */
public class FastCollinearPoints {

    private List<LineSegment> lineSegments;

    public FastCollinearPoints(Point[] points) {// finds all line segments containing 4 or more points
        lineSegments = new ArrayList<>();
        if (points == null) throw new NullPointerException();
        for (int i = 0; i < points.length; i++) {
            //points[i].c
        }
    }

    public int numberOfSegments() {
        return 0;
    }        // the number of line segments

    public LineSegment[] segments() {
        return null;
    }                // the line segments
}
