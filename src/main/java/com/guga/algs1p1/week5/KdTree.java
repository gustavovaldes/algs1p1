package com.guga.algs1p1.week5;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by guga
 */
public class KdTree {

    private Node root;

    public KdTree() {  // construct an empty set of points

    }

    public static void main(String[] args) { // unit testing of the methods (optional)
    }

    public boolean isEmpty() {  // is the set empty?
        return false;
    }

    public int size() { // number of points in the set
        return 0;
    }

    public void insert(Point2D p) { // add the point to the set (if it is not already in the set)
        if (root == null) {
            root = new Node(p);
            RectHV r = new RectHV(0, 0, 1, 1);
            root.rect = r;
        } else {
            root = insert(root, p, true);
        }
    }

    private Node insert(Node node, Point2D point, boolean compareByX) {

        if (node == null) return new Node(point);
        if (node.p.equals(point)) return node;

        double direction = 0;
        if (compareByX) {
            direction = point.x() - node.p.x();
        } else {
            direction = point.y() - node.p.y();

        }
        RectHV r = null;
        if (direction < 0) {
            node.lb = insert(node.lb, point, !compareByX);
            if (node.lb.rect == null) {
                if (compareByX) {
                    r = new RectHV(node.rect.xmin(), node.rect.ymin(), node.p.x(), node.rect.ymax());
                } else {
                    r = new RectHV(node.rect.xmin(), node.rect.ymin(), node.rect.xmax(), node.p.y());
                }
                node.lb.rect = r;
            }
        } else {
            node.rt = insert(node.rt, point, !compareByX);
            if (node.rt.rect == null) {
                if (compareByX) {
                    r = new RectHV(node.p.x(), node.rect.ymin(), node.rect.xmax(), node.rect.ymax());
                } else {
                    r = new RectHV(node.rect.xmin(), node.p.y(), node.rect.xmax(), node.rect.ymax());
                }
                node.rt.rect = r;
            }
        }

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
        if (root != null) draw(root, true);
    }

    private void draw(Node node, boolean compareByX) {
        if (node != null) {
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setPenRadius(.01);
            node.p.draw();
            if(compareByX){
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.setPenRadius(.01);
            }else{
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.setPenRadius(.01);
            }

            node.rect.draw();
            draw(node.lb, !compareByX);
            draw(node.rt, !compareByX);
        }
    }

    public Iterable<Point2D> range(RectHV rect) { // all points that are inside the rectangle
        return null;
    }

    public Point2D nearest(Point2D p) { // a nearest neighbor in the set to point p; null if the set is empty

        return null;
    }

    private class Node {
        private Point2D p;      // the point
        private RectHV rect;    // the axis-aligned rectangle corresponding to this node
        private Node lb;        // the left/bottom subtree
        private Node rt;        // the right/top subtree

        Node(Point2D p) {
            this.p = p;
        }
    }

}
