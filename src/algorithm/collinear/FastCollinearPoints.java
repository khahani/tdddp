package algorithm.collinear;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class FastCollinearPoints implements CollinearPoints {
    private int size;
    private LineSegment[] linesegments;

    public FastCollinearPoints(Point[] points) {// finds all line segments containing 4 or more points
        notNull(points);

        Point[] thePoints = points.clone();

        noDuplicate(thePoints);

        final int n = thePoints.length;
        Arrays.sort(thePoints);
        final Point[] sortedPoints = thePoints.clone();

        Point[] tempLineSegments = new Point[n * n];
        for (int i = 0; i < n; i++) {
            Arrays.sort(thePoints, sortedPoints[i].slopeOrder());

            for (int j = 0; j < n; j++) {
                int count = 0;
                while (j + count < n) {
                    if (sortedPoints[i].slopeTo(thePoints[j]) != sortedPoints[i].slopeTo(thePoints[j + count])) break;
                    count++;
                }
                if (count > 2) {
                    Arrays.sort(thePoints, j, j + count);
                    if (thePoints[0].compareTo(thePoints[j]) < 0)
                        exch(thePoints, 0, j);
                    else if (thePoints[0].compareTo(thePoints[j + count - 1]) > 0)
                        exch(thePoints, 0, j + count - 1);
                    boolean duplicate = false;
                    for (int k = 0; k < size; k += 2) {
                        if (tempLineSegments[k].compareTo(thePoints[j]) == 0 &&
                                tempLineSegments[k + 1].compareTo(thePoints[j + count - 1]) == 0) {
                            duplicate = true;
                            break;
                        }
                    }
                    if (!duplicate) {
                        tempLineSegments[size++] = thePoints[j];
                        tempLineSegments[size++] = thePoints[j + count - 1];
                    }
                    break;
                }
            }
        }


        linesegments = new LineSegment[size / 2];
        for (int i = 0; i < size; i += 2) {
            linesegments[i / 2] = new LineSegment(tempLineSegments[i], tempLineSegments[i + 1]);
        }

    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        //StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

    private void exch(Object[] thePoints, int i, int j) {
        Object swap = thePoints[i];
        thePoints[i] = thePoints[j];
        thePoints[j] = swap;
    }

    private void notNull(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException();

        for (Point point : points) {
            if (null == point) throw new IllegalArgumentException();
        }
    }

    private void noDuplicate(Point[] thePoints) {
        for (int i = 0; i < thePoints.length - 1; i++) {
            if (thePoints[i].compareTo(thePoints[i + 1]) == 0)
                throw new IllegalArgumentException();
        }
    }

    public int numberOfSegments() {   // the number of line segments
        return linesegments.length;
    }

    public LineSegment[] segments() {                // the line segments
        final int size = numberOfSegments();
        LineSegment[] copy = new LineSegment[size];
        for (int i = 0; i < size; i++) {
            copy[i] = linesegments[i];
        }
        return copy;
    }
}
