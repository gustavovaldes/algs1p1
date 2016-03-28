package com.guga.algs1p1.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by guga
 */
public class KdTree {

    private Node root;

    public KdTree() {  // construct an empty set of points

    }

    public boolean isEmpty() {  // is the set empty?
        return false;
    }

    public int size() { // number of points in the set
        return 0;
    }

    public void insert(Point2D p) { // add the point to the set (if it is not already in the set)
        if (root == null) {
            root = new Node(p, new RectHV(0, 0, 1, 1));
        } else {
            root = insert(root, p, true);
        }
    }

    private Node insert(Node node, Point2D point, boolean verticalSplit) {

        if (node == null) return new Node(point, null);
        double direction = 0;
        if (verticalSplit) {
            direction = point.x() - node.p.x();
        } else {
            direction = point.y() - node.p.y();

        }
        if (direction < 0) node.lb = insert(node.lb, point, !verticalSplit);
        else node.rt = insert(node.rt, point, !verticalSplit);
        return node;
    }

    public boolean contains(Point2D p) {  // does the set contain point p?
        if (root == null) return false;
        return contains(root, p, true);
    }

    private boolean contains(Node node, Point2D p, boolean verticalDirection) {
        if (node == null) return false;
        double direction = 0;
        if (verticalDirection) {
            direction = p.x() - node.p.x();
            if (direction == 0) {
                if (p.y() == node.p.y()) return true;
            }
        } else {
            direction = p.y() - node.p.y();
            if (direction == 0) {
                if (p.x() == node.p.x()) return true;
            }
        }
        if (direction < 0) return contains(node.lb, p, !verticalDirection);
        else return contains(node.rt, p, !verticalDirection);

    }

    public void draw() { // draw all points to standard draw
        if (root != null) draw(root);
    }

    private void draw(Node node) {
        if (node != null) {
            node.p.draw();
            draw(node.lb);
            draw(node.rt);
        }
    }

    public Iterable<Point2D> range(RectHV rect) { // all points that are inside the rectangle
        return null;
    }

    public Point2D nearest(Point2D p) { // a nearest neighbor in the set to point p; null if the set is empty

        return null;
    }

    public static void main(String[] args) { // unit testing of the methods (optional)
    }


    private class Node {
        private Point2D p;      // the point
        private RectHV rect;    // the axis-aligned rectangle corresponding to this node
        private Node lb;        // the left/bottom subtree
        private Node rt;        // the right/top subtree

        Node(Point2D p, RectHV r) {
            this.p = p;
            this.rect = r;
        }
    }

}
