package com.guga.algs1p1.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

/**
 * Created by guga
 */
public class PointSET {

    private SET<Point2D> points;

    public PointSET() {  // construct an empty set of points
        points = new SET<>();
    }

    public boolean isEmpty() {  // is the set empty?
        return size() == 0;
    }

    public int size() { // number of points in the set
        return points.size();
    }

    public void insert(Point2D p) { // add the point to the set (if it is not already in the set)
        points.add(p);
    }

    public boolean contains(Point2D p) {  // does the set contain point p?
        return points.contains(p);
    }

    public void draw() { // draw all points to standard draw
        for (Point2D point : points) {
            point.draw();
        }
    }

    public Iterable<Point2D> range(RectHV rect) { // all points that are inside the rectangle
        SET<Point2D> inner = new SET<>();
        for (Point2D point : points) {
            if (rect.xmin() <= point.x() && rect.xmax() >= point.x() &&
                    rect.ymin() <= point.y() && rect.ymax() >= point.y()) {
                inner.add(point);
            }
        }
        return inner;
    }

    public Point2D nearest(Point2D p) { // a nearest neighbor in the set to point p; null if the set is empty
        Point2D nearest = null;
        double distance = Double.MAX_VALUE;
        for (Point2D point : points) {
            double localDistance = point.distanceSquaredTo(p);
            if (localDistance < distance) {
                distance = localDistance;
                nearest = point;
            }
        }
        return nearest;
    }

    public static void main(String[] args) { // unit testing of the methods (optional)
    }
}
