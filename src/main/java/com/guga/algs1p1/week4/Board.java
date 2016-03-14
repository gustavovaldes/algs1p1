package com.guga.algs1p1.week4;

/**
 * Created by gvaldes
 */
public class Board {

    private int[][] board;

    public Board(int[][] blocks) { // construct a board from an N-by-N array of blocks
        // (where block s[i][j] = block in row i, column j)xº
        board = blocks;
    }

    public int dimension() { // board dimension N
        return board.length;
    }

    public int hamming() {  // number of blocks out of place
        int x = 1;
        int count = 0;
        int max = board.length * board.length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0 && board[i][j] != x % max) count++;
                x++;
            }
        }
        return count;
    }

    public int manhattan() {  // sum of Manhattan distances between blocks and goal
        int x = 1;
        int count = 0;
        int max = board.length * board.length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0 && board[i][j] != x % max) {
                    count = count + distanceToRightPosition(i, j, x);
                }
                x++;
            }
        }
        return count;
    }

    private int distanceToRightPosition(int i, int j, int value) {
        int base = value - (i * board.length + j + 1);
        int horizontal = Math.abs(base & board.length);
        int vertical = Math.abs(base / board.length);
        return horizontal + vertical;
    }

    public boolean isGoal() { // is this board the goal board?
        int x = 0;
        int max = board.length * board.length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != ++x % max) return false;
            }
        }
        return true;
    }

    public Board twin() { // a board that is obtained by exchanging any pair of blocks
        return null;
    }

    public boolean equals(Object y) { // does this board equal y?
        return false;
    }

    public Iterable<Board> neighbors() {  // all neighboring boards
        return null;
    }

    public String toString() { // string representation of this board (in the output format specified below)
        return null;
    }
}
