package com.guga.algs1p1.week2;

/**
 * Created by guga
 */
public class InsertionSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                    exchange(a, j, j-1);
                } else {
                    break;
                }

            }
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
