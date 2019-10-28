import java.util.Arrays;

/**
 * class to find the number of pairs given in an array.
 */
class LBD {

    LBD() {
    }
    /**
     * main function.
     * the time complexity of the function is Nlog(N).
     * @param args main function parameters.
     */
    public static void main(final String[] args) {

        final int[] arr = {1, 4, 3, 6, 4, 7, 9, 9, 5, 3, 7, 9};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count += 1;
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
