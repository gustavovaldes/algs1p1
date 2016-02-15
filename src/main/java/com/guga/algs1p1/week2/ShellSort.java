package com.guga.algs1p1.week2;

/**
 * Created by guga
 *
 * Worst case number of compares using 3x + 1 increment is O( N ^ 3/2 )
 *
 * Useful in practice unless array is huge, is fast and no use extra space ("fast" considering his simplicity).
 * Tiny code, suitable for embedded systems. Hardware sort prototype *
 */
public class ShellSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;//initial h 1,4,13,40,121,364,...

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j - h])) {
                        exchange(a, j, j - h);
                    }
                }
            }
            h = h / 3;
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
