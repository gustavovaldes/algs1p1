package com.guga.algs1p1.week4;

/**
 * Created by gvaldes
 */
public class MaxPriorityQueue<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;


    public MaxPriorityQueue(int capacity) {  //can be implemented with resize
        this.N = capacity;
        pq = (Key[]) new Comparable[N + 1];
    }


    public void insert(Key key){

    }

    public Key deleteMax(){
        return null;
    }



    private void swim(int k) {

    }

    private void sink(int k) {

    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
