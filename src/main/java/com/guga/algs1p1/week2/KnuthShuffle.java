package com.guga.algs1p1.week2;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by guga
 */
public class KnuthShuffle {

    public static void shuffle(Object[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(i + 1);
            exchange(a, i, r);
        }
    }

    private static void exchange(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
