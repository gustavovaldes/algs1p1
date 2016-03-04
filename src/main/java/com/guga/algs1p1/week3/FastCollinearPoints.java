package com.guga.algs1p1.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by guga
 */
public class FastCollinearPoints {

    private List<LineSegment> lineSegments;

    public FastCollinearPoints(Point[] input) {// finds all line segments containing 4 or more points
        lineSegments = new ArrayList<>();
        int n = input.length;

        Point[] sorted = Arrays.copyOf(input, n);

        if (input == null) throw new NullPointerException();
        for (int i = 0; i < n; i++) {
            Point point = input[i];
            Arrays.sort(sorted, point.slopeOrder());
            int counter = 1;
            double slope = point.slopeTo(sorted[0]);
            for (int j = 1; j <= n; j++) {
                if (j == n) {
                    if (counter >= 3) {//collinear
                        Point[] segment = Arrays.copyOfRange(sorted, j - counter - 1, j);// -1: 1 additional place
                        // for original point
                        segment[0] = point;//include the original
                        extractSegment(segment); // ( ] (inclusive,exclusive range)
                    }
                    break;
                }
                double tempSlope = point.slopeTo(sorted[j]);
                if(tempSlope==Double.NEGATIVE_INFINITY) throw new IllegalArgumentException();
                //if(tempSlope==Double.NEGATIVE_INFINITY) continue; //same point
                if (slope == tempSlope) {//same point, border condition// maybe include here -tempSlope
                    counter++;
                } else {
                    if (counter >= 3) {//collinear
                        Point[] segment = Arrays.copyOfRange(sorted, j - counter - 1, j);// -1: 1 additional place
                        // for original point
                        segment[0] = point;//include the original
                        extractSegment(segment); // ( ] (inclusive,exclusive range)
                    }
                    counter = 1;
                }
                slope = tempSlope;
            }
        }
    }

    private void extractSegment(Point... points) {
        Arrays.sort(points);
        LineSegment segment = new LineSegment(points[0], points[points.length - 1]);
        for (LineSegment lineSegment : lineSegments) {
            if (lineSegment.toString().equals(segment.toString())) return;
        }
        lineSegments.add(segment);
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
