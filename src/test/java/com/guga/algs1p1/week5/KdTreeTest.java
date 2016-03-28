package com.guga.algs1p1.week5;

import edu.princeton.cs.algs4.Point2D;
import org.junit.Test;

/**
 * Created by guga
 */
public class KdTreeTest {

    @Test
    public void test() {
        KdTree kdTree = new KdTree();
        Point2D p1 = new Point2D(0.2d, 0.2d);
        Point2D p2 = new Point2D(0.1d, 0.3d);
        Point2D p3 = new Point2D(0.5d, 0.1d);
        Point2D p4 = new Point2D(0.2d, 0.3d);

        Point2D p5 = new Point2D(0.7d, 0.1d);

        System.out.println(kdTree.contains(p1));

        kdTree.insert(p1);
        kdTree.insert(p2);
        kdTree.insert(p3);
        kdTree.insert(p4);


        System.out.println(kdTree.contains(p1));
        System.out.println(kdTree.contains(p2));
        System.out.println(kdTree.contains(p3));
        System.out.println(kdTree.contains(p4));
        System.out.println(kdTree.contains(p5));

        kdTree.insert(p2);
        kdTree.insert(p3);

        System.out.println(kdTree.contains(p1));
        System.out.println(kdTree.contains(p2));
        System.out.println(kdTree.contains(p3));
        System.out.println(kdTree.contains(p4));
        System.out.println(kdTree.contains(p5));

        kdTree.size();

    }
}
