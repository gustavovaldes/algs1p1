package com.guga.algs1p1.week2;

/**
 * Created by guga
 */
public interface Queue<ITEM> {

    void enqueue(ITEM item);

    ITEM dequeue();

    boolean isEmpty();

    int size();
}
