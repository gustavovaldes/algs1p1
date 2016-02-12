package com.guga.algs1p1.week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by guga
 */
public class Subset {

    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        int k = Integer.parseInt(args[0]);
        int j = 0;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (j >= k) {
                int val = StdRandom.uniform(j+1);
                if (val < k) {
                    rq.dequeue();
                    rq.enqueue(s);
                }

            } else {
                rq.enqueue(s);
            }
            j++;
        }

        for (int i = 0; i < k; i++) {
            System.out.println(rq.dequeue());
        }

    }
}
