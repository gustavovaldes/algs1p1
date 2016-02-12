package com.guga.algs1p1.week2;

/**
 * Created by guga
 */
public class QueueLinkedList<ITEM> implements Queue<ITEM> {

    private Node<ITEM> first, last;
    private int N;

    @Override
    public void enqueue(ITEM item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if(isEmpty()){
            first = last;
        }else{
            oldLast.next = last;
        }
        N++;
    }

    @Override
    public ITEM dequeue() {
        if(isEmpty()) throw  new RuntimeException("Empty Queue!!!");
        ITEM item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }

    private class Node<T>{
        T item;
        Node next;
    }
}
