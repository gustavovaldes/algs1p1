package com.guga.algs1p1.week2;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by guga
 *
 * Simple Stack based on linkedList
 */
public class StackLinkedList<T> implements Stack<T> {

    private Node<T> first = null;
    private int count = 0;

    @Override
    public void push(T value) {
        Node oldFirst = first;
        first = new Node<>();
        first.value = value;
        first.next = oldFirst;
        count++;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Empty Stack!!!");
        T val = first.value;
        first = first.next;
        count--;
        return val;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    private class Node<ITEM> {
        Node next;
        ITEM value;
    }
}
