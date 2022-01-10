package algorithm.percolation.assignment;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONSTANT_PARAM = 1.96;
    private final int trials;
    private final double[] fractions;
    private final int n;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();

        this.n = n;
        this.trials = trials;
        fractions = new double[this.trials];
        run();
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            StdOut.println("Please provide n, and T as arguments for the program.");
            return;
        }
        final int n = Integer.parseInt(args[0]);
        final int T = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, T);

        StdOut.print(String.format("%1$-24s = %2$f\n", "mean", ps.mean()));
        StdOut.print(String.format("%1$-24s = %2$f\n", "stddev", ps.stddev()));
        StdOut.print(String.format("%1$-24s = [%2$f, %3$f]\n", "95% confidence interval", ps.confidenceLo(), ps.confidenceHi()));
    }

    private void run() {
        for (int trial = 0; trial < trials; trial++) {
            simulation(trial);
        }
    }

    private void simulation(int trial) {
        Percolation percolation = new Percolation(n);
        do {
            int row;
            int col;
            boolean isOpen;
            do {
                row = StdRandom.uniform(1, n + 1);
                col = StdRandom.uniform(1, n + 1);
                try {
                    isOpen = percolation.isOpen(row, col);
                } catch (IllegalArgumentException ignored) {
                    isOpen = false;
                }
            } while (isOpen);

            percolation.open(row, col);
        } while (!percolation.percolates());

        fractions[trial] = (double) percolation.numberOfOpenSites() / (n * n);
    }

    // sample standard deviation of percolation threshold

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(fractions);
    }
    // low endpoint of 95% confidence interval

    public double stddev() {
        return StdStats.stddev(fractions);
    }
    // high endpoint of 95% confidence interval

    public double confidenceLo() {
        return mean() - (CONSTANT_PARAM * stddev()) / Math.sqrt(trials);
    }
    // test client (see below)

    public double confidenceHi() {
        return mean() + (CONSTANT_PARAM * stddev()) / Math.sqrt(trials);
    }

}