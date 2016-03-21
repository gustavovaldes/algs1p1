package com.guga.algs1p1.week4;

import org.junit.Test;

/**
 * Created by gvaldes
 */
public class BSTTest {

    @Test
    public void test(){
        BST<Character, Integer> bst = new BST<>();
        bst.put('M', 1);
        bst.put('A', 2);
        bst.put('X', 3);
        bst.put('E', 4);

        System.out.println(bst.size());
        System.out.println(bst.get('M'));
        System.out.println(bst.get('A'));
        System.out.println(bst.get('X'));
        System.out.println(bst.get('E'));
        System.out.println(bst.get('D'));

    }
}
