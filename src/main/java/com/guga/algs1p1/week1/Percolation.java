package com.guga.algs1p1.week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final byte OPEN = 1;
    //private WeightedQuickUnionUF uf2;
    private static final byte FULL = 2;
    private WeightedQuickUnionUF uf1;
    private byte[] control;
    private int N;
    private int top; //virtual top node
    private int bottom; //virtual bottom node


    public Percolation(int N) {               // create N-by-N grid, with all sites blocked
        this.N = N;
        if (N <= 0) throw new IllegalArgumentException();
        uf1 = new WeightedQuickUnionUF(N * N + 2);
        //uf2 = new WeightedQuickUnionUF(N * N + 1);
        control = new byte[N * N + 2];
        top = 0;
        bottom = N * N + 1;
        control[top] = FULL;
    }


    public static void main(String[] args) { // test client (optional)


    }

    public void open(int i, int j) { // open site (row i, column j) if it is

        // not open already

        validateRange(i, j);

        int pos = calculatePosition(i, j);

        if (control[pos] >= OPEN) return;

        control[pos] = OPEN;
        if (pos > 0 && pos <= N) {
            uf1.union(top, pos);
            control[pos] = FULL;
            flagFulls(i, j, pos);
            //System.out.println("uniendo " + top + " y " + pos);
        }
        if (pos > N * (N - 1)) {
            uf1.union(pos, bottom);
            //System.out.println("uniendo* " + bottom + " y " + pos);
        }

        int next = 0;

        /*arriba*/

        if (i > 1) {

            next = pos - N;

            if (control[next] >= OPEN) {
                uf1.union(pos, next);
                if (control[next] == FULL) {
                    control[pos] = FULL;
                }
                //uf2.union(pos, next);
                //System.out.println("* " + pos + " y " + next);
            }

        }



        /*abajo*/

        if (i < N) {

            next = pos + N;

            if (control[next] >= OPEN) {

                uf1.union(pos, next);
                if (control[next] == FULL) {
                    control[pos] = FULL;
                }
                //uf2.union(pos, next);
                //System.out.println("* " + pos + " y " + next);
            }
        }



        /*izquierda*/

        if (j > 1) {

            next = pos - 1;

            if (control[next] >= OPEN) {

                uf1.union(pos, next);
                if (control[next] == FULL) {
                    control[pos] = FULL;
                }
                //uf2.union(pos, next);
                //System.out.println("* " + pos + " y " + next);
            }

        }



        /*derecha*/

        if (j < N) {

            next = pos + 1;

            if (control[next] >= OPEN) {
                uf1.union(pos, next);
                if (control[next] == FULL) {
                    control[pos] = FULL;
                }
                //uf2.union(pos, next);
                //System.out.println("* " + pos + " y " + next);
            }

        }

        if (control[pos] == FULL) {
            flagFulls(i, j, pos);
        }

    }

    private void flagFulls(int i, int j, int pos) {
        int next = 0;

        /*arriba*/
        if (i > 1) {
            next = pos - N;
            if (control[next] == OPEN) {
                control[next] = FULL;
                flagFulls(i - 1, j, next);
            }
        }

        /*abajo*/
        if (i < N) {
            next = pos + N;
            if (control[next] == OPEN) {
                control[next] = FULL;
                flagFulls(i + 1, j, next);
            }
        }

        /*izquierda*/
        if (j > 1) {
            next = pos - 1;
            if (control[next] == OPEN) {
                control[next] = FULL;
                flagFulls(i, j - 1, next);
            }
        }

        /*derecha*/
        if (j < N) {
            next = pos + 1;
            if (control[next] == OPEN) {
                control[next] = FULL;
                flagFulls(i, j + 1, next);
            }
        }

    }


    public boolean isOpen(int i, int j) { // is site (row i, column j) open?

        validateRange(i, j);

        return control[calculatePosition(i, j)] >= OPEN;

    }

    public boolean isFull(int i, int j) { // is site (row i, column j) full?
        if (!isOpen(i, j)) return false;
        int pos = calculatePosition(i, j);
        //return uf2.connected(top, pos);
        return control[pos] == FULL;
    }


    public boolean percolates() { // does the system percolate?

        if (N == 1) return control[1] >= OPEN;
        return uf1.connected(top, bottom);

    }


    private void validateRange(int i, int j) {

        if (i < 1 || i > N || j < 1 || j > N)

            throw new IndexOutOfBoundsException();

    }


    private int calculatePosition(int i, int j) {

        return (N) * (i - 1) + j;

    }

}