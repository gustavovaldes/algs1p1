package com.guga.algs1p1.week4;

import edu.princeton.cs.algs4.MinPQ;

import java.util.Stack;

/**
 * Created by gvaldes
 */
public class Board {

    int N;
    private int[][] board;

    public Board(int[][] blocks) { // construct a board from an N-by-N array of blocks
        // (where block s[i][j] = block in row i, column j)
        board = blocks;
        N = board.length;
    }

    private void createNeighbors(int i, int j, Stack stack) {

        if (i > 0) { //up
            int[][] up = cloneBoard();
            up[i][j] = board[i - 1][j];
            up[i - 1][j] = board[i][j];
            stack.push(new Board(up));
        }
        if (i < N) { //bottom
            int[][] bottom = cloneBoard();
            bottom[i][j] = board[i + 1][j];
            bottom[i + 1][j] = board[i][j];
            stack.push(new Board(bottom));
        }
        if (j > 0) { //left
            int[][] left = cloneBoard();
            left[i][j] = board[i][j - 1];
            left[i][j - 1] = board[i][j];
            stack.push(new Board(left));
        }
        if (j < N) { //right
            int[][] right = cloneBoard();
            right[i][j] = board[i][j + 1];
            right[i][j + 1] = board[i][j];
            stack.push(new Board(right));
        }

    }

    private int[][] cloneBoard() {
        int[][] clonedBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                clonedBoard[i][j] = board[i][j];
            }
        }
        return clonedBoard;
    }

    public int dimension() { // board dimension N
        return N;
    }

    public int hamming() {  // number of blocks out of place
        int x = 1;
        int count = 0;
        int max = N * N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0 && board[i][j] != x % max) count++;
                x++;
            }
        }
        return count;
    }

    public int manhattan() {  // sum of Manhattan distances between blocks and goal
        int x = 1;
        int count = 0;
        int max = N * N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0 && board[i][j] != x % max) {
                    count = count + distanceToRightPosition(i, j, board[i][j]);
                }
                x++;
            }
        }
        return count;
    }

    private int distanceToRightPosition(int i, int j, int value) {
        int iVal = (value - 1) / N;
        int jVal = (value - 1) % N;
        return Math.abs(i - iVal) + Math.abs(j - jVal);
    }

    public boolean isGoal() { // is this board the goal board?
        int x = 0;
        int max = N * N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != ++x % max) return false;
            }
        }
        return true;
    }

    public Board twin() { // a board that is obtained by exchanging any pair of blocks

        int[][] b = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                b[i][j] = board[i][j];
            }
        }

        if (board[0][0] == 0 || board[0][1] == 0) {
            b[1][0] = board[1][1];
            b[1][1] = board[1][0];
        } else {
            b[0][0] = board[0][1];
            b[0][1] = board[0][0];
        }
        return new Board(b);
    }

    public boolean equals(Object y) { // does this board equal y?
        Board that = (Board) y;
        if (that.dimension() != this.dimension()) return false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (that.board[i][j] != this.board[i][j]) return false;
            }
        }
        return true;
    }

    public Iterable<Board> neighbors() {  // all neighboring boards
        Stack<Board> stack = new Stack<>();
        outer:
        for (int i = 0; i < N; i++) {
            inner:
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    createNeighbors(i, j, stack);
                    break outer;
                }
            }
        }
        return stack;
    }

    public String toString() { // string representation of this board (in the output format specified below)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
                sb.append(" ");
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
