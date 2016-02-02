package com.guga.algs1p1.week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF uf1;
    private WeightedQuickUnionUF uf2;

    private boolean[] records;
    private int N;
    private int top; //virtual top node
    private int bottom; //virtual bottom node


    public Percolation(int N) {               // create N-by-N grid, with all sites blocked
        this.N = N;
        if (N <= 0) throw new IllegalArgumentException();
        uf1 = new WeightedQuickUnionUF(N * N + 2);
        uf2 = new WeightedQuickUnionUF(N * N + 1);
        records = new boolean[N * N];
        top = N * N;
        bottom = N * N + 1;
    }


    public static void main(String[] args) { // test client (optional)


    }

    public void open(int i, int j) { // open site (row i, column j) if it is

        // not open already

        validateRange(i, j);

        int pos = calculatePosition(i, j);

        if (records[pos]) return;

        records[pos] = true;
        if (pos < N) {
            uf1.union(top, pos);
            uf2.union(top, pos);
            //System.out.println("uniendo " + top + " y " + pos);
        }
        if (pos >= N * (N - 1)) {
            uf1.union(pos, bottom);
            //System.out.println("uniendo* " + bottom + " y " + pos);
        }

        int next = 0;

        /*arriba*/

        if (i > 1) {

            next = pos - N;

            if (records[next]) {
                uf1.union(pos, next);
                uf2.union(pos, next);
                //System.out.println("* " + pos + " y " + next);
            }

        }



        /*abajo*/

        if (i < N) {

            next = pos + N;

            if (records[next]) {

                uf1.union(pos, next);
                uf2.union(pos, next);
                //System.out.println("* " + pos + " y " + next);
            }
        }



        /*izquierda*/

        if (j > 1) {

            next = pos - 1;

            if (records[next]) {

                uf1.union(pos, next);
                uf2.union(pos, next);
                //System.out.println("* " + pos + " y " + next);
            }

        }



        /*derecha*/

        if (j < N) {

            next = pos + 1;

            if (records[next]) {
                uf1.union(pos, next);
                uf2.union(pos, next);
                //System.out.println("* " + pos + " y " + next);
            }

        }

    }


    public boolean isOpen(int i, int j) { // is site (row i, column j) open?

        validateRange(i, j);

        return records[calculatePosition(i, j)];

    }

    public boolean isFull(int i, int j) {// is site (row i, column j) full?
        if (!isOpen(i, j)) return false;
        int pos = calculatePosition(i, j);
        return uf2.connected(top, pos);
    }


    public boolean percolates() { // does the system percolate?

        if (N == 1) return records[0];
        return uf1.connected(top, bottom);

    }


    private void validateRange(int i, int j) {

        if (i < 1 || i > N || j < 1 || j > N)

            throw new IndexOutOfBoundsException();

    }


    private int calculatePosition(int i, int j) {

        return (N) * (i - 1) + j - 1;

    }

}