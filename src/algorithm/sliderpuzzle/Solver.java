package algorithm.sliderpuzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.EmptyStackException;
import java.util.Iterator;

public class Solver {

    private final boolean isSolvable;
    private SearchNode[] solutions;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (null == initial)
            throw new IllegalArgumentException();

        MinPQ<SearchNode> pq = new MinPQ<>();
        pq.insert(new SearchNode(initial, 0, null));
        pq.insert(new SearchNode(initial.twin(), 0, null));
        int count = 0;
        while (!pq.isEmpty()) {
            count++;
            SearchNode min = pq.delMin();
            if (min.item.isGoal()) {
                reconstructPath(min);
                break;
            }

            final Iterable<Board> neighbours = min.neighbors();
            SearchNode pre = min.preview;
            Board preBoard = (pre == null) ? null : pre.item;

            for (Board board :
                    neighbours) {
                if (!board.equals(preBoard)) {
                    pq.insert(new SearchNode(board, min.moves + 1, min));
                }
            }
        }
        System.out.println(count);
        isSolvable = solutions[0].item.equals(initial);
    }


    // test client (see below)
    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                tiles[i][j] = in.readInt();
            }
        Board initial = new Board(tiles);

        // solve the puzzle
        final long start = System.currentTimeMillis();
        Solver solver = new Solver(initial);
        final long stop = System.currentTimeMillis();
        StdOut.println("Time: " + (stop - start));

//         print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

//    private boolean solveIt(MinPQ<SearchNode> pq) {
//        SearchNode min = pq.delMin();
//        if (min.item.isGoal()) {
//            this.min = min;
//            return true;
//        }
//        for (Board neighbor :
//                min.item.neighbors()) {
//            if (null != min.preview && neighbor.equals(min.preview.item)) {
//                continue;
//            }
//            pq.insert(new SearchNode(neighbor, min.moves + 1, min));
//        }
//        return false;
//    }

    private void reconstructPath(SearchNode min) {
        solutions = new SearchNode[min.moves + 1];

        for (int i = solutions.length - 1; i >= 0 && null != min; i--) {
            solutions[i] = min;
            min = min.preview;
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return isSolvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable())
            return -1;

        return solutions[solutions.length - 1].moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable())
            return null;

        return SolverIterator::new;
    }

    private static class SearchNode implements Comparable<SearchNode> {
        private final Board item;
        private final int moves;
        private final SearchNode preview;
        private final int priority;

        public SearchNode(Board item, int moves, SearchNode preview) {
            this.item = item;
            this.moves = moves;
            this.preview = preview;
            this.priority = item.manhattan() + this.moves;
        }

        @Override
        public int compareTo(SearchNode that) {
            return Integer.compare(this.priority, that.priority);
        }

        public Iterable<Board> neighbors() {
            return item.neighbors();
        }
    }

    private class SolverIterator implements Iterator<Board> {

        private int step;

        @Override
        public boolean hasNext() {
            return step != solutions.length;
        }

        @Override
        public Board next() {
            if (!hasNext()) throw new EmptyStackException();
            return solutions[step++].item;
        }
    }

}
