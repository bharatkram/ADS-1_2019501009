import java.util.Comparator;
// import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    /**
     * x-coordinate of this point.
     */
    private final int x;

    /**
     * y-coordinate of this point.
     */
    private final int y;

    /**
     * Initializes a new point.
     *
     * @param  x the x-coordinate of the point
     * @param  y the y-coordinate of the point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point.
     *
     * @param that the other point.
     * @return slope between this point and the specified point.
     */
    public double slopeTo(Point that) {
        if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        } else if (this.x == that.x && this.y == that.y) {
            return Double.NEGATIVE_INFINITY;
        }
        return (double) (that.y - this.y) / (that.x - this.x);
    }

    /**
     * function to compare two points by y-coordinate, breaking ties by x-coordinate.
     *
     * @param  that the other point
     * @return the value 0 if this point is equal to the argument
     *         point, a negative integer if this point is less than the argument
     *         point, else a positive integer if this point is greater than the
     *         argument point.
     */
    public int compareTo(Point that) {
        if (this.y != that.y) {
            return this.y - that.y;
        }
        return this.x - that.x;
    }

    private class CompareSlope implements Comparator<Point> {
        public int compare(Point one, Point two) {
            return (int) (slopeTo(one) - slopeTo(two));
        }
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        return new CompareSlope();
    }

    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        Point one = new Point(1, 2);

        System.out.println(one.compareTo(new Point(3, 4)));

        System.out.println(one.slopeTo(new Point (0, 0)));
    }
}
