//package com.guga.algs1p1.week4;

import edu.princeton.cs.algs4.MinPQ;

import java.util.Stack;

/**
 * Created by gvaldes
 */
public class Solver {

    private MinPQ<SearchNode> pq = new MinPQ<>();
    private MinPQ<SearchNode> pqTwin = new MinPQ<>();
    private int moves = 0;
    private boolean solvable = false;
    private SearchNode solution;

    public Solver(Board initial) { // find a solution to the initial board (using the A* algorithm)

        SearchNode node = new SearchNode(initial, moves, null);
        SearchNode nodeTwin = new SearchNode(initial.twin(), moves, null);

        pq.insert(node);
        pqTwin.insert(nodeTwin);

        while (!solvable) {
            SearchNode sn = pq.delMin();
            moves++;
            if (!sn.board.isGoal()) {
                Iterable<Board> i = sn.board.neighbors();
                for (Board board : i) {
                    if (!board.equals(sn.board)) {
                        pq.insert(new SearchNode(board, moves, sn));
                    }
                }

            } else {
                solvable = true;
                solution = sn;
            }

            SearchNode snTwin = pqTwin.delMin();
            if (!snTwin.board.isGoal()) {
                Iterable<Board> i = snTwin.board.neighbors();
                for (Board board : i) {
                    if (!board.equals(snTwin.board)) {
                        pq.insert(new SearchNode(board, moves, snTwin));
                    }
                }
            } else {
                solvable = false;
                return;
            }

        }
    }

    public static void main(String[] args) { // solve a slider puzzle (given below)
    }

    public boolean isSolvable() { // is the initial board solvable?
        return solvable;
    }

    public int moves() {  // min number of moves to solve initial board; -1 if unsolvable
        return moves;
    }

    public Iterable<Board> solution() { // sequence of boards in a shortest solution; null if unsolvable
        if (!solvable) return null;
        SearchNode temp = solution;
        Stack<Board> stack = new Stack<>();
        while(temp!=null){
            stack.add(temp.board);
            temp = temp.previous;
        }
        return stack;
    }

    private class SearchNode implements Comparable<SearchNode> {
        private Board board;
        private SearchNode previous;
        private int moves;

        SearchNode(Board board, int moves, SearchNode previous) {
            this.board = board;
            this.moves = moves;
            this.previous = previous;
        }

        @Override
        public int compareTo(SearchNode o) {
            return Integer.compare (this.board.manhattan() + this.moves,
                    o.board.manhattan() + o.moves);
        }
    }
}


