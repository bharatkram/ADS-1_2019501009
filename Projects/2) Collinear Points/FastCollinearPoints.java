import java.lang.IllegalArgumentException;
import java.util.Arrays;

public class FastCollinearPoints {
    Point[] points;
    int numOfSeg;
    LineSegment[] lines;

    public FastCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < points.length; i++) {
                if (points[i] == null) {
                    throw new IllegalArgumentException();
                }
                for (int j = i; j > 0; j--) {
                    if (points[j].compareTo(points[j - 1]) == 0) {
                        throw new IllegalArgumentException();
                    } else if (points[j].compareTo(points[j - 1]) < 0) {
                        Point temp = points[j];
                        points[j] = points[j - 1];
                        points[j - 1] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
        this.points = points;
        numOfSeg = 0;
    }

    public int numberOfSegments() {
        return numOfSeg;
    }

    public LineSegment[] segments() {
        for (int i = 0; i < points.length; i++) {
            Arrays.sort(points, SlopeOrder());
        }
    }
}