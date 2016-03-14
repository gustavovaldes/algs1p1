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
                    count = count + distanceToRightPosition(i, j, board[i][j]);
                }
                x++;
            }
        }
        return count;
    }

    private int distanceToRightPosition(int i, int j, int value) {
        int iVal = (value - 1) / board.length;
        int jVal = (value - 1) % board.length;
        return Math.abs(i - iVal) + Math.abs(j - jVal);
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

        int[][] b = new int[board.length][board.length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (that.board[i][j] != this.board[i][j]) return false;
            }
        }
        return true;
    }

    public Iterable<Board> neighbors() {  // all neighboring boards
        return null;
    }

    public String toString() { // string representation of this board (in the output format specified below)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
                sb.append(" ");
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
