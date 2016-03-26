package com.guga.algs1p1.week4;

/**
 * Binary Search Tree
 * Created by gvaldes
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    public BST() {

    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1);
        int direction = key.compareTo(node.key);
        if (direction > 0) node.right = put(node.right, key, value);
        else if (direction < 9) node.left = put(node.left, key, value);
        else node.value = value;
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) return null;
        int direction = key.compareTo(node.key);
        if (direction > 0) return get(node.right, key);
        else if (direction < 0) return get(node.left, key);
        else return node.value;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.N;
    }

    public Value min() {
        if (root == null) return null;
        else return min(root).value;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        else return node.left;
    }

    public Value max() {
        if (root == null) return null;
        else return max(root).value;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        else return node.right;
    }


    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
}
