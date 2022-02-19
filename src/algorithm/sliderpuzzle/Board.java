package algorithm.sliderpuzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class Board {

    private final int[][] tiles;
    private int hammingPriority;
    private int manhattanPriority;
    private int[][] goal;
    private Board twin;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if (tiles == null)
            throw new IllegalArgumentException();
        final int n = tiles.length;
        this.tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            System.arraycopy(tiles[i], 0, this.tiles[i], 0, n);
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
        Board board = new Board(tails);
        StdOut.println(board.isGoal());
        StdOut.println(board.isGoal());
        StdOut.println(board.isGoal());
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
        final int n = tiles.length;
        if (goal == null) {
            goal = new int[n][n];
            int number = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    goal[i][j] = number++;
                }
            }
            goal[n - 1][n - 1] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] != goal[i][j])
                    return false;
            }
        }
        return true;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (this == y) return true;
        if (null == y) return false;
        if (this.getClass() != y.getClass()) return false;

        final Board that = (Board) y;
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
    public Iterable<Board> neighbors() {
        return NeighborIterator::new;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
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
        twin = new Board(localTiles);
        return twin;
    }

    private class NeighborIterator implements Iterator<Board> {

        private final Board[] boards;
        private final int size;
        private int visited;

        public NeighborIterator() {

            final int[][] tiles = Board.this.tiles;
            final int n = tiles.length;
            final Board[] tempBoards = new Board[4];
            int tempSize = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (tiles[i][j] == 0) {
                        if (i > 0) { // up
                            exch(tiles, i, j, i - 1, j);
                            tempBoards[tempSize++] = new Board(tiles);
                            exch(tiles, i - 1, j, i, j);
                        }
                        if (i < n - 1) {
                            exch(tiles, i, j, i + 1, j);
                            tempBoards[tempSize++] = new Board(tiles);
                            exch(tiles, i + 1, j, i, j);
                        }
                        if (j > 0) {
                            exch(tiles, i, j, i, j - 1);
                            tempBoards[tempSize++] = new Board(tiles);
                            exch(tiles, i, j - 1, i, j);
                        }
                        if (j < n - 1) {
                            exch(tiles, i, j, i, j + 1);
                            tempBoards[tempSize++] = new Board(tiles);
                            exch(tiles, i, j + 1, i, j);
                        }
                        break;
                    }
                }
            }

            size = tempSize;
            boards = new Board[size];
            System.arraycopy(tempBoards, 0, boards, 0, size);

        }

        private void exch(int[][] tiles, int i, int j, int x, int y) {
            int swap = tiles[i][j];
            tiles[i][j] = tiles[x][y];
            tiles[x][y] = swap;
        }

        @Override
        public boolean hasNext() {
            return visited < size;
        }

        @Override
        public Board next() {
            return boards[visited++];
        }
    }
}
