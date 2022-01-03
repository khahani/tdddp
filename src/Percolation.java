//import edu.princeton.cs.algs4.StdRandom;
//import edu.princeton.cs.algs4.StdStats;
//import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Percolation {

    private static final int CLOSE = 0;
    private static final int OPEN = 1;
    public final int N;
    private final int[] sites;
    private final int[] status;
    private final int[] weights;

    // creates n-by-n grid, with all sites initially blockedpublic Percolation(int n)

    public Percolation(int N) {
        this.N = N;
        validEntry(N);

        final int ADDITIONAL_HEAD_AND_TAIL_SITE = 2;
        final int length = (N * N) + ADDITIONAL_HEAD_AND_TAIL_SITE;
        sites = new int[length];
        status = new int[length];
        weights = new int[length];

        for (int i = 0; i < sites.length; i++) {
            sites[i] = i;
            status[i] = CLOSE;
            weights[i] = 1;
        }

        openHeadAndTail();
    }

    // test client (optional)
    public static void main(String[] args) {

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validEntry(row);
        validEntry(col);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validEntry(row);
        validEntry(col);

        throw new NotImplementedException();
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validEntry(row);
        validEntry(col);

        throw new NotImplementedException();
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        throw new NotImplementedException();
    }

    // does the system percolate?
    public boolean percolates() {
        throw new NotImplementedException();
    }

    private void validEntry(int rowOrColumn) {
        if (rowOrColumn < 0 || rowOrColumn > N)
            throw new IllegalArgumentException();
    }

    public int getIndex(int row, int col) {
        validEntry(row);
        validEntry(col);
        return ((row - 1) * N) + col;
    }

    public int getTailIndex() {
        return getIndex(N, N) + 1;
    }

    //region Testing purpose methods
    public int[] getStatus() {
        return status;
    }

    public int[] getWeights() {
        return weights;
    }

    private void openHeadAndTail() {
        status[0] = status[status.length - 1] = OPEN;
    }

    public int[] getSites() {
        return sites;
    }
    //endregion
}
