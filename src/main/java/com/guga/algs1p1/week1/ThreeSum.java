package com.guga.algs1p1.week1;

/**
 * Created by guga
 *
 * brute force version -> N^3
 */
public class ThreeSum {

    public static int count(int[] array) {
        int result = 0;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int i1 = i + 1; i1 < n; i1++) {
                for (int i2 = i1 + 1; i2 < n; i2++) {
                    if (array[i] + array[i1] + array[i2] == 0) {
                        result++;
                        //System.out.println(array[i]+ " "+array[i1] +" "+array[i2]);
                    }
                }
            }
        }
        return result;
    }
}

