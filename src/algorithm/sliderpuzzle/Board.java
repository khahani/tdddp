package algorithm.sliderpuzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Board {

    private final int[] tiles;
    private int dimension;
    private int hamming = -1;
    private int manhattan = -1;
    private Board twin;

    public Board(int[][] tiles) {
        if (tiles == null)
            throw new IllegalArgumentException();
        final int n = tiles.length * tiles.length;
        this.tiles = new int[n];
        int k = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                this.tiles[k++] = tiles[i][j];
            }
        }
    }

    private Board(int[] tiles) {
        if (tiles == null)
            throw new IllegalArgumentException();
        final int n = tiles.length;
        this.tiles = new int[n];
        for (int i = 0; i < n; i++) {
            this.tiles[i] = tiles[i];
        }
    }

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
        StdOut.println(initial.manhattan());
        final long stop = System.currentTimeMillis();
        StdOut.println("Time: " + (stop - start));
    }

    private static void show(Board b) {
        StdOut.println(b.toString());
        for (Board board :
                b.neighbors()) {
            StdOut.println(board.toString());
        }
        StdOut.println("****************");
    }

    public String toString() {
        final int n = tiles.length;
        StringBuilder s = new StringBuilder();
        s.append(dimension()).append("\n");
        for (int i = 0; i < n; i++) {
            s.append(String.format("%2d ", tiles[i]));
            if ((i + 1) % dimension() == 0)
                s.append("\n");
        }
        return s.toString();
    }

    public int dimension() {
        if (dimension != 0)
            return dimension;
        dimension = (int) Math.sqrt(tiles.length);
        return dimension;
    }

    public int hamming() {
        if (hamming != -1)
            return hamming;

        int h = 0;
        for (int i = 0; i < tiles.length; i++)
            if (tiles[i] != 0 && tiles[i] != i + 1)
                h++;

        hamming = h;
        return hamming;
    }

    public int manhattan() {
        if (this.manhattan != -1)
            return this.manhattan;
        final int n = tiles.length;
        int[][] tiles = new int[dimension()][dimension()];
        for (int i = 0, row = 0, col = 0; i < n; i++) {
            tiles[row][col] = this.tiles[i];
            col++;
            if ((i + 1) % dimension() == 0) {
                row++;
                col = 0;
            }
        }
        int m = 0;
        for (int i = 0; i < dimension(); i++)
            for (int j = 0; j < dimension(); j++) {
                if (tiles[i][j] != 0 && tiles[i][j] != (i * dimension()) + j + 1) {
                    int[] indices = getIndices(tiles[i][j]);
                    final int h = Math.abs(i - indices[0]);
                    final int v = Math.abs(j - indices[1]);
                    m += h + v;
                }
            }
        this.manhattan = m;
        return this.manhattan;
    }

    private int[] getIndices(int number) {
        int[] result = new int[2];
        final int n = dimension();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (number == (i * n) + j + 1) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean isGoal() {
        return hamming() == 0;
    }

    public boolean equals(Object y) {
        if (this == y) return true;
        if (null == y) return false;
        if (this.getClass() != y.getClass()) return false;

        final Board that = (Board) y;
        final int n = tiles.length;
        if (n != that.tiles.length)
            return false;

        for (int i = 0; i < n; i++)
            if (tiles[i] != that.tiles[i])
                return false;
        return true;
    }

    public Iterable<Board> neighbors() {
        return NeighborIterator::new;
    }

    public Board twin() {
        if (twin != null)
            return twin;

        final int n = tiles.length;
        int[] localTiles = new int[n];
        for (int i = 0; i < n; i++) {
            localTiles[i] = tiles[i];
        }

        for (int i = 0; i < n; i++) {
            if (localTiles[i] != 0 && localTiles[i + 1] != 0) {
                exch(localTiles, i, i + 1);
                break;
            }
        }
        twin = new Board(localTiles);
        return twin;
    }

    private void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;

    }

    private class NeighborIterator implements Iterator<Board> {
        private final Stack<Board> boards;

        public NeighborIterator() {
            boards = new Stack<>();

            for (int i = 0; i < tiles.length; i++)
                if (tiles[i] == 0) {
                    if (canGoUp(i)) {
                        makeNeighbor(boards, i, i - dimension());
                    }
                    if (canGoDown(i)) {
                        makeNeighbor(boards, i, i + dimension());
                    }
                    if (canGoRight(i)) {
                        makeNeighbor(boards, i, i + 1);
                    }
                    if (canGoLeft(i)) {
                        makeNeighbor(boards, i, i - 1);
                    }
                }
        }

        private boolean canGoLeft(int zeroIndex) {
            if (zeroIndex == 0)
                return false;
            if (zeroIndex == 1)
                return true;
            return zeroIndex % dimension() != 0;
        }

        private boolean canGoRight(int zeroIndex) {
            if (zeroIndex == tiles.length - 1)
                return false;
            if (zeroIndex == 0)
                return true;
            return (zeroIndex + 1) % dimension() != 0;
        }

        private void makeNeighbor(Stack<Board> t, int zeroIndex, int newIndex) {
            exch(tiles, zeroIndex, newIndex);
            t.push(new Board(tiles));
            exch(tiles, newIndex, zeroIndex);
        }

        private boolean canGoDown(int zeroIndex) {
            return zeroIndex < tiles.length - dimension();
        }

        private boolean canGoUp(int zeroIndex) {
            return zeroIndex + 1 > dimension();
        }

        @Override
        public boolean hasNext() {
            return !boards.isEmpty();
        }

        @Override
        public Board next() {
            if (!hasNext())
                throw new IllegalStateException();

            return boards.pop();
        }
    }
}
