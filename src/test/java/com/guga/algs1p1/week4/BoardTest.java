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
    public void testManhattan(){



        int[][] board = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        //Assert.assertEquals(0, new Board(board).manhattan());

        board = new int[][]{{4, 5, 6}, {1, 2, 3}, {7, 8, 0}};
        Assert.assertEquals(3, new Board(board).manhattan());
    }
}
