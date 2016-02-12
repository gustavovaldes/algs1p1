package com.guga.algs1p1.week1;

public class BinarySearch {

    private int[] array;

    public BinarySearch(int[] values){
        this.array = values;
    }

    public int find(int x) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (x > array[mid]) lo = mid + 1;
            else if (x < array[mid]) hi = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static int find(int[] values, int x){
        int lo = 0;
        int hi = values.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (x > values[mid]) lo = mid + 1;
            else if (x < values[mid]) hi = mid - 1;
            else return mid;
        }
        return -1;
    }


}
