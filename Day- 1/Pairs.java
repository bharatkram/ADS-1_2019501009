final class Pairs {

    private Pairs() {
    }
    public static void main(final String[] args) {
        final int[] arr1 = {1, 2, 3, 4, 5};
        final int[] arr2 = {1, 3, 4, 5, 6};

        int i = 0;
        // int d = 0;
        // while (i < arr1.length) {
        //     if (arr1[i] == arr2[i + d]) {
        //         System.out.print(arr1[i] + ", ");
        //     } else if (arr1[i] < arr2[i + d]) {
        //         d -= 1;
        //     } else {
        //         d += 1;
        //     }
        //     i += 1;
        // } System.out.print("\n");

        i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                System.out.println(arr1[i]);
                i += 1;
            } else if (arr2[j] < arr1[i]) {
                System.out.println(arr2[j]);
                j += 1;
            } else {
                System.out.println(arr1[i]);
                System.out.println(arr2[j]);
                i++;
                j++;
            }
        }
        while (i < arr1.length) {
                System.out.println(arr1[i]);
                i += 1;
            }
        while (j < arr2.length) {
                System.out.println(arr2[j]);
                j += 1;
            }
        }
}
