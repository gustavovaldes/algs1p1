package com.guga.algs1p1.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by guga
 */
public class KdTree {

    Set<Point2D> RBT = new TreeSet<>();

    public KdTree() {  // construct an empty set of points
    }

    public boolean isEmpty() {  // is the set empty?
        return false;
    }

    public int size() { // number of points in the set
        return 0;
    }

    public void insert(Point2D p) { // add the point to the set (if it is not already in the set)
    }

    public boolean contains(Point2D p) {  // does the set contain point p?
        return false;
    }

    public void draw() { // draw all points to standard draw
    }

    public Iterable<Point2D> range(RectHV rect) { // all points that are inside the rectangle
        return null;
    }

    public Point2D nearest(Point2D p) { // a nearest neighbor in the set to point p; null if the set is empty

        return null;
    }

    public static void main(String[] args) { // unit testing of the methods (optional)
    }
}
