import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Arrays;
// import edu.princeton.cs.algs4.StdIn;
// import edu.princeton.cs.algs4.StdOut;
// import edu.princeton.cs.algs4.StdRandom;

public class FastCollinearPoints {
    private Point[] points;
    private int numOfSeg;
    private LineSegment[] lines;

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

        ArrayList<LineSegment> linesArray = new ArrayList<LineSegment>();

        Point[] temp = Arrays.copyOf(points, points.length);

        for (int i = 0; i < points.length; i++) {
            Arrays.sort(points);
            Arrays.sort(temp, points[i].slopeOrder());
            int count = 1;
            for (int j = 0; j < temp.length - 1; j++) {
                // System.out.println(points[i].slopeTo(temp[j]) + " " + points[i].slopeTo(temp[j + 1]));
                if (points[i].slopeTo(temp[j]) == points[i].slopeTo(temp[j + 1])) {
                    // System.out.println(count);
                    count += 1;
                    if (count >= 4 && j == temp.length - 2){
                        linesArray.add(new LineSegment(points[i], temp[j + 1]));
                    }
                } else if (count >= 4) {
                    linesArray.add(new LineSegment(points[i], temp[j]));
                    count = 1;
                } else {
                    count = 1;
                }
            }
            // System.out.println("\n");
        }

        lines = linesArray.toArray(new LineSegment[linesArray.size()]);
    }

    public int numberOfSegments() {
        return numOfSeg;
    }

    public LineSegment[] segments() {
        return lines;
    }

    // public static void main(String[] args) {

    //     // read the n points from a file
    //     In in = new In(args[0]);
    //     int n = in.readInt();
    //     Point[] points = new Point[n];
    //     for (int i = 0; i < n; i++) {
    //         int x = in.readInt();
    //         int y = in.readInt();
    //         points[i] = new Point(x, y);
    //     }

    //     // draw the points
    //     StdDraw.enableDoubleBuffering();
    //     StdDraw.setXscale(0, 32768);
    //     StdDraw.setYscale(0, 32768);
    //     for (Point p : points) {
    //         p.draw();
    //     }
    //     StdDraw.show();
    
    //     // print and draw the line segments
    //     FastCollinearPoints collinear = new FastCollinearPoints(points);
    //     for (LineSegment segment : collinear.segments()) {
    //         StdOut.println(segment);
    //         segment.draw();
    //     }
    //     StdDraw.show();
    // }
}