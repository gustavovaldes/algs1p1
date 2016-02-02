package com.guga.algs1p1.week1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] results;
    private double mean;
    private double std;
    private int T;

    public PercolationStats(int N, int T) { // perform T independent experiments on an N-by-N grid
        this.T=T;
        if (N <= 0 || T <= 0) throw new IllegalArgumentException();
        results = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation percolation = new Percolation(N);
            int j = 0;
            while (!percolation.percolates()) {
                int x = StdRandom.uniform(N) + 1;
                int y = StdRandom.uniform(N) + 1;
                if (!percolation.isOpen(x, y)) {
                    percolation.open(x, y);
                    j++;
                }
            }
            results[i] = (double) j / (N * N);
        }
        mean = StdStats.mean(results);
        std = StdStats.stddev(results);
    }

    public static void main(String[] args) {// test client (described below)
        PercolationStats s = new PercolationStats(2, 100000);
        System.out.println(s.mean());
        System.out.println(s.stddev());
        System.out.println(s.confidenceLo());
        System.out.println(s.confidenceHi());
    }

    public double mean() { // sample mean of percolation threshold
        return mean;
    }

    public double stddev() { // sample standard deviation of percolation threshold
        return std;
    }

    public double confidenceLo() {  // low  endpoint of 95% confidence interval
        return mean - (std * 1.96 / Math.sqrt(T));
    }

    public double confidenceHi() {// high endpoint of 95% confidence interval
        return mean + (std * 1.96 / Math.sqrt(T));
    }
}