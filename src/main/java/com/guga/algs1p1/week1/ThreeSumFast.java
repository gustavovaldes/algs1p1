package com.guga.algs1p1.week1;

import java.util.Arrays;

/**
 * Created by guga
 *
 * third loop replaced by a binarySearch looking for the difference to complete zero.
 * with this i can get N^2 lg N
 */
public class ThreeSumFast {

    public static int count(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int k = BinarySearch.find(a, -(a[i] + a[j]));
                if (k > j) count++;
            }
        }
        return count;
    }
}
