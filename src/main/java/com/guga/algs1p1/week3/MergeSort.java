package com.guga.algs1p1.week3;

/**
 * Created by guga
 * <p>
 * Uses at most N lg N compares and 6 N lg N array accesses to sort any array of size N
 */
public class MergeSort {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (hi <= lo) return;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * Merge a[lo..mid] with a[mid+1..hi]
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int lowPivot = lo;
        int midPivot = mid + 1;

        for (int k = lo; k <= hi; k++) { // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) { // Merge back to a[lo..hi].
            if (lowPivot > mid) a[k] = aux[midPivot++];
            else if (midPivot > hi) a[k] = aux[lowPivot++];
            else if (less(aux[midPivot], aux[lowPivot])) a[k] = aux[midPivot++];
            else a[k] = aux[lowPivot++];
        }
    }

    private static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }


    //todo implement MergeSortBU
}
