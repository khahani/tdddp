package algorithm.kdtree;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

public class PointSET {
    private final SET<Point2D> data;

    // construct an empty set of points
    public PointSET() {
        data = new SET<>();
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
    }

    // is the set empty?
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // number of points in the set
    public int size() {
        return data.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        data.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        return data.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        for (Point2D p : data)
            p.draw();
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        if (null == rect)
            throw new IllegalArgumentException();

        SET<Point2D> r = new SET<>();
        for (Point2D p : data) {
            if (rect.contains(p))
                r.add(p);
        }
        return r;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (null == p)
            throw new IllegalArgumentException();

        if (data.isEmpty())
            return null;

        final Point2D point = new Point2D(p.x(), p.y());
        MinPQ<Point2D> pq = new MinPQ<>((o1, o2) -> {
            final double d1 = point.distanceSquaredTo(o1);
            final double d2 = point.distanceSquaredTo(o2);
            return Double.compare(d1, d2);
        });

        for (Point2D x :
                data) {
            pq.insert(x);
        }
//        Point2D minPoint = data.max();
//        double minDistance = p.distanceSquaredTo(minPoint);
//        double curDis;
//        for (Point2D curPoint :
//                data) {
//            curDis = p.distanceSquaredTo(curPoint);
//            if (curDis < minDistance) {
//                minPoint = curPoint;
//                minDistance = curDis;
//            }
//        }
//        return minPoint;
        return new Point2D(pq.min().x(), pq.min().y());
    }
}