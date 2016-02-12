package com.guga.algs1p1.week2;

/**
 * Created by guga
 */
public interface Stack<ITEM> extends  Iterable<ITEM>{
    void push(ITEM i);
    ITEM pop();
    boolean isEmpty();
    int size();
}
