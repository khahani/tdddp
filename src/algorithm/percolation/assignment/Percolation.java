package algorithm.percolation.assignment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private static final boolean OPEN = true;
    private static final int HEAD_INDEX = 0;
    private final int n;
    private final boolean[] status;
    private final WeightedQuickUnionUF uf;
    private int numberOfOpenSite = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(final int n) {
        this.n = n;
        if (isNotValid(n)) {
            throw new IllegalArgumentException();
        }
        uf = new WeightedQuickUnionUF(getLength());
        status = new boolean[getLength()];
        openHeadAndTail();
    }

    private void openHeadAndTail() {
        status[HEAD_INDEX] = OPEN;
        status[getTailIndex()] = OPEN;
    }

    private void openSite(int index) {
        status[index] = OPEN;
        numberOfOpenSite++;
    }

    // opens the site (row, col) if it is not open already

    public void open(int row, int col) {
        if (isNotValid(row) || isNotValid(col))
            throw new IllegalArgumentException();

        final int siteIndex = getIndex(row, col);

        if (!isOpen(row, col))
            openSite(siteIndex);

        if (row == 1) {
            unionWithTopVirtual(siteIndex);
        }

        if (row == n) {
            unionWithBottomVirtual(siteIndex);
        }

        unionWithNeighbors(row, col, siteIndex);
    }

    private void unionWithBottomVirtual(int siteIndex) {
        uf.union(siteIndex, getTailIndex());
    }

    private void unionWithTopVirtual(int siteIndex) {
        uf.union(siteIndex, HEAD_INDEX);
    }

    private void unionWithNeighbors(final int row, final int col, final int siteIndex) {
        final int top = row - 1;
        final int bottom = row + 1;
        final int left = col - 1;
        final int right = col + 1;

        if (isValid(top)) {
            if (isOpen(top, col))
                uf.union(getIndex(top, col), siteIndex);
        }

        if (isValid(bottom)) {
            if (isOpen(bottom, col))
                uf.union(getIndex(bottom, col), siteIndex);
        }

        if (isValid(right)) {
            if (isOpen(row, right))
                uf.union(getIndex(row, right), siteIndex);
        }

        if (isValid(left)) {
            if (isOpen(row, left))
                uf.union(getIndex(row, left), siteIndex);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (isNotValid(row) || isNotValid(col))
            throw new IllegalArgumentException();

        return status[getIndex(row, col)] == OPEN;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (isNotValid(row) || isNotValid(col))
            throw new IllegalArgumentException();

        return isOpen(row, col) && uf.find(getIndex(row, col)) == uf.find(HEAD_INDEX);
    }

    // returns the number of open sites

    public int numberOfOpenSites() {
        return numberOfOpenSite;
    }
    // does the system percolate?

    public boolean percolates() {
        return uf.find(HEAD_INDEX) == uf.find(getTailIndex());
    }

    private boolean isNotValid(int rowOrColumn) {
        return rowOrColumn <= 0 || rowOrColumn > n;
    }

    private boolean isValid(int rowOrColumn) {
        return rowOrColumn > 0 && rowOrColumn <= n;
    }

    private int getLength() {
        final int ADDITIONAL_HEAD_AND_TAIL_SITE = 2;
        return (n * n) + ADDITIONAL_HEAD_AND_TAIL_SITE;
    }

    private int getIndex(int row, int col) {
        if (isNotValid(row) || isNotValid(col))
            throw new IllegalArgumentException();

        return ((row - 1) * n) + col;
    }

    private int getTailIndex() {
        return getIndex(n, n) + 1;
    }

}
