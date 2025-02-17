import java.util.Collections;
import java.util.PriorityQueue;

final class Solution {

    private Solution() {
    }

    /**
     * function to find the dynamic median of the given array.
     * @param arr the input array containing the elements.
     * @return the medians found per insertion of array.
     */
    public static double[] dynamicMedian(final double[] arr) {

        PriorityQueue<Double> minQ = new PriorityQueue<Double>();

        PriorityQueue<Double> maxQ = new PriorityQueue<Double>(
                                        Collections.reverseOrder());

        double[] res = new double[arr.length];

        double median = arr[0];

        minQ.add(median);
        res[0] = median;

        for (int i = 1; i < arr.length; i++) {
            if (minQ.size() > maxQ.size()) {
                if (arr[i] > median) {
                    maxQ.add(minQ.remove());
                    minQ.add(arr[i]);
                } else {
                    maxQ.add(arr[i]);
                }
                median = (minQ.peek() + maxQ.peek()) / 2.0;
            } else if (minQ.size() < maxQ.size()) {
                if (arr[i] < median) {
                    minQ.add(maxQ.remove());
                    maxQ.add(arr[i]);
                } else {
                    minQ.add(arr[i]);
                }
                median = (minQ.peek() + maxQ.peek()) / 2.0;
            } else {
                if (arr[i] < median) {
                    maxQ.add(arr[i]);
                    median = maxQ.peek();
                } else {
                    minQ.add(arr[i]);
                    median = minQ.peek();
                }
            }
            res[i] = median;
        }
        return res;
    }
}
