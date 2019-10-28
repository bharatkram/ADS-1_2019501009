import java.util.Arrays;

/**
 * class to solve the 3 sum problem.
 */
public class Sum {

    /**
     * main function
     * the time complexity of the function is (N^2)Log(N).
     * @param args main function parameters.
     */
    public static void main(final String[] args) {
        final int[] arr = {30, -40, -20, -10, 0, 40, 10, 5};

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int low = 0;
                int high = arr.length - 1;
                int mid = (low + high) / 2;
                while (low <= high) {
                    mid = (low + high) / 2;
                    if (-arr[mid] > arr[i] + arr[j]) {
                        low = mid + 1;
                    } else if (-arr[mid] < arr[i] + arr[j]) {
                        high = mid - 1;
                    } else {
                        if (arr[i] < arr[j] && arr[j] < arr[mid]) {
                            count += 1;
                            System.out.println(arr[i] + " " + arr[j]
                                    + " " + arr[mid]);
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
