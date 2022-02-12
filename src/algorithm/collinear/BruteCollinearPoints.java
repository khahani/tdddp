package algorithm.collinear;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BruteCollinearPoints implements CollinearPoints {

    private LineSegment[] lineSegments;
    private int size = 0;

    public BruteCollinearPoints(Point[] points) {
        // finds all line segments containing 4 points
        notnull(points);
        Point[] thePoints = Arrays.copyOf(points, points.length);
        Arrays.sort(thePoints);
        validate(thePoints);

        final int n = thePoints.length;
        LineSegment[] s = new LineSegment[n * n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (thePoints[i].slopeTo(thePoints[j]) == thePoints[i].slopeTo(thePoints[k]) &&
                                thePoints[i].slopeTo(thePoints[k]) == thePoints[i].slopeTo(thePoints[l])
                        ) {
                            s[size++] = new LineSegment(thePoints[i], thePoints[l]);
                        }
                    }
                }
            }
        }

        lineSegments = new LineSegment[size];
        for (int i = 0; i < size; i++) {
            lineSegments[i] = s[i];
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

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);

        for (LineSegment segment : collinear.segments()) {
            if (null == segment)
                break;
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

    private void validate(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            Point p1 = points[i];
            Point p2 = points[i + 1];
            if (p1.compareTo(p2) == 0)
                throw new IllegalArgumentException();
        }
    }

    private void notnull(Point[] points) {
        if (points == null)
            throw new IllegalArgumentException();
        for (Point point : points) {
            if (null == point)
                throw new IllegalArgumentException();
        }
    }

    public int numberOfSegments() {        // the number of line segments
        return lineSegments.length;
    }

    public LineSegment[] segments() {                // the line segments
        final int size = numberOfSegments();
        LineSegment[] copy = new LineSegment[size];
        for (int i = 0; i < size; i++) {
            copy[i] = lineSegments[i];
        }
        return copy;
    }
}
