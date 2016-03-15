package com.guga.algs1p1.week4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;


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

        while (true) {
            SearchNode sn = pq.delMin();
            if (!sn.board.isGoal()) {
                for (Board board : sn.board.neighbors()) {
                    SearchNode itNode = new SearchNode(board, sn.moves + 1, sn);
                    if (!itNode.equals(sn.previous)) {
                        pq.insert(itNode);
                    }
                }

            } else {
                solvable = true;
                solution = sn;
                moves = sn.moves;
                return;
            }


            SearchNode snTwin = pqTwin.delMin();
            if (!snTwin.board.isGoal()) {
                for (Board board : snTwin.board.neighbors()) {
                    SearchNode itNode = new SearchNode(board, snTwin.moves + 1, snTwin);
                    if (!itNode.equals(snTwin.previous)) {
                        pqTwin.insert(itNode);
                    }
                }
            } else {
                moves = -1;
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
        SearchNode temp = new SearchNode(solution.board, solution.moves, solution.previous);
        Stack<Board> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.board);
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
            return Integer.compare(this.board.manhattan() + this.moves,
                    o.board.manhattan() + o.moves);
        }

        public boolean equals(Object that) {
            if (that == this) return true;
            if (that == null) return false;
            if (that.getClass() != this.getClass()) return false;

            SearchNode node = (SearchNode) that;
            if (node.board.equals(board)) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return board.toString().hashCode();
        }
    }
}


