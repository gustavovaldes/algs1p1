package com.guga.algs1p1.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by guga
 */
public class FastCollinearPoints {

    private List<LineSegment> lineSegments;
    private List<Point> selectedPoints = new ArrayList<>();

    public FastCollinearPoints(Point[] input) {// finds all line segments containing 4 or more points
        lineSegments = new ArrayList<>();
        int n = input.length;
        if(n<2) return;

        Point[] sorted = Arrays.copyOf(input, n);

        if (input == null) throw new NullPointerException();
        for (int i = 0; i < n; i++) {
            Point point = input[i];
            Arrays.sort(sorted, point.slopeOrder());

            Point min = sorted[1];
            Point max = sorted[1];
            if (point.compareTo(sorted[1]) > 0) max = point;
            else  min = point;//else

            int counter = 2;

            double slope = point.slopeTo(sorted[1]);
            if (slope == Double.NEGATIVE_INFINITY) throw new IllegalArgumentException();

            for (int j = 2; j <= n; j++) {
                if (j == n) {
                    if (counter >= 4) {//collinear
                        //Point[] segment = Arrays.copyOfRange(sorted, j - counter - 1, j);// -1: 1 additional place
                        // for original point
                        //segment[0] = point;//include the original
                        extractSegment(min, max); // ( ] (inclusive,exclusive range)
                    }
                    break;
                }
                double tempSlope = point.slopeTo(sorted[j]);
                if (tempSlope == Double.NEGATIVE_INFINITY) throw new IllegalArgumentException();
                //if(tempSlope==Double.NEGATIVE_INFINITY) continue; //same point
                if (slope == tempSlope) {//same point, border condition// maybe inc
                    // lude here -tempSlope
                    counter++;
                    if (max.compareTo(sorted[j]) < 0) max = sorted[j];
                    if (min.compareTo(sorted[j]) > 0) min = sorted[j];//else
                } else {
                    if (counter >= 4) {//collinear
                        //Point[] segment = Arrays.copyOfRange(sorted, j - counter - 1, j);// -1: 1 additional place
                        // for original point
                        //segment[0] = point;//include the original
                        extractSegment(min, max); // ( ] (inclusive,exclusive range)
                    }
                    counter = 1;
                    if(slope== point.slopeTo(sorted[j-1])) counter++;
                    min= point;
                    max= point;
                    if (point.compareTo(sorted[j]) < 0) max = sorted[j];
                    else min = sorted[j];//else
                }
                slope = tempSlope;
            }
        }
    }

    /*private void extractSegment(Point... points) {
        Arrays.sort(points);
        LineSegment segment = new LineSegment(points[0], points[points.length - 1]);
        for (LineSegment lineSegment : lineSegments) {
            if (lineSegment.toString().equals(segment.toString())) return;
        }
        lineSegments.add(segment);
    }*/

    private void extractSegment(Point p1, Point p2) {
        for (int i = 0; i < selectedPoints.size(); i = i + 2) {
            if (selectedPoints.get(i).compareTo(p1) == 0 && selectedPoints.get(i + 1).compareTo(p2) == 0) return;
        }
        selectedPoints.add(p1);
        selectedPoints.add(p2);
        lineSegments.add(new LineSegment(p1, p2));
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
