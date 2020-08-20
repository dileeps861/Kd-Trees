import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Set;
import java.util.TreeSet;

public class PointSET {
    private final Set<Point2D> points;

    // construct an empty set of points
    public PointSET() {
        points = new TreeSet<>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return points.isEmpty();
    }

    // number of points in the set
    public int size() {
        return points.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        assertNull(p);
        if (!contains(p)) {
            points.add(p);
        }
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        assertNull(p);
        return points.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        StdDraw.setPenRadius(0.2);
        StdDraw.setPenColor(StdDraw.RED);
        for (Point2D point : points) {
            StdDraw.point(point.x(), point.y());
        }

    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {
        assertNull(rect);
        Stack<Point2D> pointsInRange = new Stack<>();
        for (Point2D point : points) {
            if ((point.x() <= rect.xmax() && point.x() >= rect.xmin()) &&
                    (point.y() <= rect.ymax() && point.y() >= rect.ymin())
            ) {
                pointsInRange.push(point);
            }
        }

        return pointsInRange;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        assertNull(p);
        Point2D nearestPoint = null;
        for (Point2D point : points) {
            if (nearestPoint == null) nearestPoint = point;
            else if (p.distanceTo(point) < p.distanceTo(nearestPoint)) nearestPoint = point;
        }
        return nearestPoint;
    }
    // Assert if the input argument is null
    private void assertNull(Object obj) {
        if (obj == null) throw new IllegalArgumentException("Argument cannot be null");
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
        // Auto generated, need to implement
        KdTree kdTree = new KdTree();
        double x = StdRandom.uniform(0.0, 1.0);
        double y = StdRandom.uniform(0.0, 1.0);
        Point2D point = new Point2D(x, y);
        kdTree.insert(point);
    }
}
