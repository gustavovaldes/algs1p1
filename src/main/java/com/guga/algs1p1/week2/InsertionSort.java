package com.guga.algs1p1.week2;

/**
 * Created by guga
 *
 * Insertion sort uses N ^ 2 / 4 compares and N ^2 / 4 exchanges to sort
 * a randomly ordered array of length N with distinct keys, on the average. The worst
 * case is N ^2 / 2 compares and N ^ 2 / 2 exchanges and the best case is N - 1 compares
 * and 0 exchanges.
 *
 * It can be a suitable option if the array is already sorted or mostly sorted, if most of the values are equals ,
 * or for tiny arrays too.
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
