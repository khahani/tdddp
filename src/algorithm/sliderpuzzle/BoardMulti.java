package algorithm.sliderpuzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class BoardMulti {

    private final int[][] tiles;
    private int hammingPriority;
    private int manhattanPriority;
    private int[][] goal;
    private BoardMulti twin;
    private int row0;
    private int col0;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public BoardMulti(int[][] tiles) {
        if (tiles == null)
            throw new IllegalArgumentException();
        final int n = tiles.length;
        this.tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                this.tiles[i][j] = tiles[i][j];
                if (tiles[i][j] == 0) {
                    row0 = i;
                    col0 = j;
                }
            }
    }


    // unit testing (not graded)
    public static void main(String[] args) {
        In in = new In(args[0]);

        final int n = in.readInt();
        int[][] tails = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tails[i][j] = in.readInt();
            }
        }
        BoardMulti board = new BoardMulti(tails);
        StdOut.println(board.manhattan());
    }

    // string representation of this board
    public String toString() {
        final int n = tiles.length;
        StringBuilder s = new StringBuilder();
        s.append(n).append("\n");
        for (int[] tile : tiles) {
            for (int j = 0; j < n; j++) {
                s.append(String.format("%2d ", tile[j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    // board dimension n

    public int dimension() {
        return tiles.length;
    }

    // number of tiles out of place

    public int hamming() {
        if (hammingPriority != 0)
            return hammingPriority;

        int hamming = 0;
        final int n = tiles.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] != 0 && tiles[i][j] != (i * n) + j + 1)
                    hamming++;
            }
        hammingPriority = hamming;
        return hamming;
    }

    // sum of Manhattan distances between tiles and goal

    public int manhattan() {
        if (manhattanPriority != 0)
            return manhattanPriority;
        int manhattan = 0;
        final int n = tiles.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] != 0 && tiles[i][j] != (i * n) + j + 1) {
                    int[] indices = getIndices(tiles[i][j]);
                    final int h = Math.abs(i - indices[0]);
                    final int v = Math.abs(j - indices[1]);
                    manhattan += h + v;
                }
            }
        manhattanPriority = manhattan;
        return manhattan;
    }

    private int[] getIndices(int number) {
        int[] result = new int[2];
        final int n = tiles.length;
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

    // is this board the goal board?

    public boolean isGoal() {
        return hamming() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (this == y) return true;
        if (null == y) return false;
        if (this.getClass() != y.getClass()) return false;

        final BoardMulti that = (BoardMulti) y;
        final int n = tiles.length;
        if (n != that.tiles.length)
            return false;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (tiles[i][j] != that.tiles[i][j])
                    return false;
        return true;
    }

    // all neighboring boards

    public Iterable<BoardMulti> neighbors() {
        return NeighborIterator::new;
    }

    // a board that is obtained by exchanging any pair of tiles

    public BoardMulti twin() {
        if (twin != null)
            return twin;

        final int n = tiles.length;
        int[][] localTiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                localTiles[i][j] = tiles[i][j];
            }
        }
        while (true) {
            int i = StdRandom.uniform(n);
            int j = StdRandom.uniform(n);
            int x = StdRandom.uniform(n);
            int y = StdRandom.uniform(n);
            if (i != x && j != y && localTiles[i][j] != 0 && localTiles[x][y] != 0) {
                int swap = localTiles[i][j];
                localTiles[i][j] = localTiles[x][y];
                localTiles[x][y] = swap;
                break;
            }
        }
        twin = new BoardMulti(localTiles);
        return twin;
    }

    private class NeighborIterator implements Iterator<BoardMulti> {

        private final BoardMulti[] boards;
        private final int size;
        private int visited;

        public NeighborIterator() {

            final int[][] tiles = BoardMulti.this.tiles;
            final int n = tiles.length;
            int tempSize = 0;

            final int i = row0;
            final int j = col0;
            if (i > 0)
                tempSize++;
            if (i < n - 1)
                tempSize++;
            if (j > 0)
                tempSize++;
            if (j < n - 1)
                tempSize++;
            size = tempSize;
            boards = new BoardMulti[tempSize];
            tempSize = 0;
            if (i > 0) { // up
                exch(tiles, i, j, i - 1, j);
                boards[tempSize++] = new BoardMulti(tiles);
                exch(tiles, i - 1, j, i, j);
            }
            if (i < n - 1) {
                exch(tiles, i, j, i + 1, j);
                boards[tempSize++] = new BoardMulti(tiles);
                exch(tiles, i + 1, j, i, j);
            }
            if (j > 0) {
                exch(tiles, i, j, i, j - 1);
                boards[tempSize++] = new BoardMulti(tiles);
                exch(tiles, i, j - 1, i, j);
            }
            if (j < n - 1) {
                exch(tiles, i, j, i, j + 1);
                boards[tempSize++] = new BoardMulti(tiles);
                exch(tiles, i, j + 1, i, j);
            }
        }

        private void exch(int[][] tiles, int i, int j, int x, int y) {
            int swap = tiles[i][j];
            tiles[i][j] = tiles[x][y];
            tiles[x][y] = swap;
        }


        public boolean hasNext() {
            return visited < size;
        }


        public BoardMulti next() {
            return boards[visited++];
        }
    }
}
