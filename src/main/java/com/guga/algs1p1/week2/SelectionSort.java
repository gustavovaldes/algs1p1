package com.guga.algs1p1.week2;

/**
 * Created by guga
 *
 * Selection sort uses N ^ 2 / 2 compares and N exchanges to sort an
 * array of length N.
 *
 * Running time is insensitive to the input.
 * It seems to be a bad option for any condition.
 */
public class SelectionSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exchange(a, i, min);
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
