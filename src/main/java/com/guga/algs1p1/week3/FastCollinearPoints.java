package com.guga.algs1p1.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by guga
 */
public class FastCollinearPoints {

    private List<LineSegment> lineSegments;

    public FastCollinearPoints(Point[] points) {// finds all line segments containing 4 or more points
        lineSegments = new ArrayList<>();
        int n = points.length;

        Point[] original = Arrays.copyOf(points, n);

        if (original == null) throw new NullPointerException();
        for (int i = 0; i < n; i++) {
            Point point = original[i];
            Arrays.sort(points, points[i].slopeOrder());
            int counter = 1;
            double slope = point.slopeTo(points[0]);
            for (int j = 1; j <= n; j++) {
                if(j==n){
                    if(counter>=3){//collinear
                        Point[] segment = Arrays.copyOfRange(points, j - counter -1 , j);// -1: 1 additional place for original point
                        //segment[j - counter -1]=point;//include the original
                        lineSegments.add(extractSegment(segment)); // ( ] (inclusive,exclusive range)
                    }
                    break;
                }
                double tempSlope = point.slopeTo(points[j]);
                if(slope==Double.POSITIVE_INFINITY) continue; //same point
                if(slope==tempSlope ){//same point, border condition// maybe include here -tempSlope
                    counter++;
                }else{
                    if(counter>=3){//collinear
                        Point[] segment = Arrays.copyOfRange(points, j - counter -1 , j);// -1: 1 additional place for original point
                        segment[0]=point;//include the original
                        lineSegments.add(extractSegment(segment)); // ( ] (inclusive,exclusive range)
                    }
                    counter=1;
                }
                slope = tempSlope;
            }
        }
    }

    private LineSegment extractSegment(Point ... points) {
        Arrays.sort(points);
        return new LineSegment(points[0], points[points.length-1]);
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
