import java.lang.IllegalArgumentException;
import java.util.Arrays;
// import edu.princeton.cs.algs4.StdIn;
// import edu.princeton.cs.algs4.StdOut;
// import edu.princeton.cs.algs4.StdRandom;

public class BruteCollinearPoints {
    private Point[] points;
    private int numOfSeg;
    private LineSegment[] lines;
    
    public BruteCollinearPoints(Point[] argPoints) {
        if (argPoints == null) {
            throw new IllegalArgumentException();
        } else {
            points = Arrays.copyOf(argPoints, argPoints.length);
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

        lines = new LineSegment[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    if (points[i].slopeTo(points[j]) == points[i].slopeTo(points[k])) {
                        for (int l = k + 1; l < points.length; l++) {
                            if (points[i].slopeTo(points[k]) == points[i].slopeTo(points[l])) {
                                lines[numOfSeg++] = new LineSegment(points[i], points[l]);
                            }
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments() {
        return numOfSeg;
    }

    public LineSegment[] segments() {
        // LineSegment[] lines = new LineSegment[points.length];
        // for (int i = 0; i < points.length; i++) {

        //     for (int j = i; j < points.length; j++) {
        //         if (j == i) {
        //             continue;
        //         }
                
        //         for (int k = j; k < points.length; k++) {
        //             if (k == j) {
        //                 continue;
        //             }
                    
        //             if (Math.abs(points[i].slopeTo(points[j])) == Math.abs(points[j].slopeTo(points[k]))) {

        //                 for (int l = k; l < points.length; l++) {
        //                     if (Math.abs(points[i].slopeTo(points[j])) == Math.abs(points[i].slopeTo(points[l]))) {
        //                         System.out.println("here");
        //                         // if (!lines.contains(new LineSegment(points[i],points[k])) && !lines.contains(new LineSegment(points[k],points[i]))) {
        //                         //     lines.add(new LineSegment(points[i],points[k]));
        //                         // }
        //                         lines[numOfSeg++] = new LineSegment(points[i], points[k]);
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
        LineSegment[] temp = new LineSegment[numOfSeg];
        for (int i = 0; i < numOfSeg; i++) {
            temp[i] = lines[i];
        }
        return temp;
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
    //     BruteCollinearPoints collinear = new BruteCollinearPoints(points);
    //     for (LineSegment segment : collinear.segments()) {
    //         StdOut.println(segment);
    //         segment.draw();
    //     }
    //     StdDraw.show();
    // }
}
