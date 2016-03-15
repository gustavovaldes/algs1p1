package com.guga.algs1p1.week4;


import edu.princeton.cs.algs4.Stack;

/**
 * Created by gvaldes
 */
public class Board {

    private int N;
    private int[][] board;

    public Board(int[][] blocks) { // construct a board from an N-by-N array of blocks
        // (where block s[i][j] = block in row i, column j)
        board = cloneBoard(blocks);
        N = board.length;
    }

    private void createNeighbors(int i, int j, Stack<Board> stack) {

        if (i > 0) { //up
            int[][] up = cloneBoard(board);
            up[i][j] = board[i - 1][j];
            up[i - 1][j] = board[i][j];
            Board b = new Board(up);
            stack.push(b);
        }
        if (i < N - 1) { //bottom
            int[][] down = cloneBoard(board);
            down[i][j] = board[i + 1][j];
            down[i + 1][j] = board[i][j];
            Board b = new Board(down);
            stack.push(b);
        }
        if (j > 0) { //left
            int[][] left = cloneBoard(board);
            left[i][j] = board[i][j - 1];
            left[i][j - 1] = board[i][j];
            Board b = new Board(left);
            stack.push(b);
        }
        if (j < N - 1) { //right
            int[][] right = cloneBoard(board);
            right[i][j] = board[i][j + 1];
            right[i][j + 1] = board[i][j];
            Board b = new Board(right);
            stack.push(b);
        }

    }

    private int[][] cloneBoard(int[][] orig) {
        int[][] clonedBoard = new int[orig.length][orig.length];
        for (int i = 0; i < orig.length; i++) {
            for (int j = 0; j < orig.length; j++) {
                clonedBoard[i][j] = orig[i][j];
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
        return hamming() == 0;
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

        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;

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
        sb.append(N);
        sb.append(System.getProperty("line.separator"));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(" ");
                sb.append(board[i][j]);
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
