package com.guga.algs1p1.week2;

import java.util.Arrays;

/**
 * Created by guga
 */
public class QueueArray<ITEM> implements Queue<ITEM> {

    int head, tail;
    ITEM[] array;
    private static final int MIN_INITIAL_CAPACITY = 2;
    int N;

    public QueueArray() {
        array = (ITEM[]) new Object[MIN_INITIAL_CAPACITY];
    }

    @Override
    public void enqueue(ITEM item) {
        ensureCapacity();
        array[tail++] = item;
        N++;
    }

    @Override
    public ITEM dequeue() {
        if(N==0) throw new RuntimeException("Empty Queue!!!");
        N--;
        ITEM item = array[head];
        array[head++] = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    private void ensureCapacity() {
        if (tail+1 == array.length) {
            ITEM[] newArray = (ITEM[] )new Object[2*array.length];
            for (int i = head; i <=tail ; i++) {
                newArray[i-head] = array[i];
            }
            array = newArray;
        }
    }
}
