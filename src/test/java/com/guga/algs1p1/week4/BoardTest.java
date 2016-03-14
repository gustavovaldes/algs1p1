package com.guga.algs1p1.week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gvaldes
 */
public class BoardTest {

    @Test
    public void testGoalAndDimension() {
        int[][] board = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Assert.assertTrue(new Board(board).isGoal());

        board = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Assert.assertFalse(new Board(board).isGoal());

        board = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 4}};
        Assert.assertFalse(new Board(board).isGoal());

        Board b = new Board(board);
        Assert.assertEquals(3, b.dimension());

    }

    @Test
    public void testHamming() {
        int[][] board = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Assert.assertEquals(0, new Board(board).hamming());

        board = new int[][]{{4, 5, 6}, {1, 2, 3}, {7, 8, 0}};
        Assert.assertEquals(6, new Board(board).hamming());

        board = new int[][]{{1, 0, 3}, {4, 5, 6}, {7, 2, 8}};
        Assert.assertEquals(2, new Board(board).hamming());
    }

    @Test
    public void testManhattan() {

        int[][] board = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Assert.assertEquals(0, new Board(board).manhattan());

        board = new int[][]{{4, 5, 6}, {1, 2, 3}, {7, 8, 0}};
        Assert.assertEquals(6, new Board(board).manhattan());

        board = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        Assert.assertEquals(0, new Board(board).manhattan());

        board = new int[][]{{1, 15, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 2, 0}};
        Assert.assertEquals(8, new Board(board).manhattan());
    }

    @Test
    public void testTwinAndEquals() {
        int[][] values = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int[][] expected1 = new int[][]{{2, 1, 3}, {4, 5, 6}, {7, 8, 0}};
        Board board = new Board(values);
        Board twin = board.twin();
        Board expectedBoard1 = new Board(expected1);

        Assert.assertTrue(expectedBoard1.equals(twin));

        int[][] values2 = new int[][]{{1, 0, 3}, {4, 5, 6}, {7, 8, 2}};
        int[][] expected2 = new int[][]{{1, 0, 3}, {5, 4, 6}, {7, 8, 2}};
        Board board2 = new Board(values2);
        Board twin2 = board2.twin();
        Board expectedBoard2 = new Board(expected2);
        Assert.assertTrue(expectedBoard2.equals(twin2));
    }
}
