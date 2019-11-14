/**
 * the class to get the farthest pair in the array.
 * @author Bharat Ram Koppu.
 */
public class FarthestPair {
    /**
     * field to store the array of doubles.
     */
    double[] arr;

    /**
     * field to store the lowest element.
     */
    double lo;

    /**
     * field to store the highest element.
     */
    double hi;

    public FarthestPair(double[] arr) {
        this.arr = arr;
        this.lo = arr[0];
        this.hi = arr[0];
    }

    /**
     * function to find the lowest and highest element in the array.
     * Time Complexity: O(N).
     *
     * @return the lowest and highest element in the array.
     */
    public double[] find() {
        for (int i = 1; i < arr.length; i++) {
            if (lo > arr[i]) {
                lo = arr[i];
            } else if (hi < arr[i]) {
                hi = arr[i];
            }
        }
        double[] output = {lo,hi};
        return output;
    }

    public static void main(String[] args) {
        double[] arr = {19.0,24.0,39.0,42.0,51.0,65.0,79.0,78.0,94.0,11.0,14.0,23.0,56.0,11.0,57.0,78.0,99.0,43.0};

        FarthestPair pair = new FarthestPair(arr);

        double[] output = pair.find();
        System.out.println(output[0] + " " + output[1]);
    }
}
