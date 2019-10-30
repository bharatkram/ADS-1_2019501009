class Solution {

	/**
	 * function to sort the array by selection method.
	 * the time complexity is (n^2).
	 *
	 * @param arr the array to be sorted.
	 * @return the sorted array.
	 */
	public int[] sortSelection(final int[] arr) {
		for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[min] - arr[j] > 0) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
		return arr;
	}

	/**
	 * function to sort the array in insertion method.
	 * the time complexity is (N^2).
	 *
	 * @param arr the array to be sorted.
	 * @return the sorted array.
	 */
	public int[] sortInsertion(final int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] <= arr[j - 1]) {
					swap(arr, j - 1, j);
				} else {
					break;
				}
			}
		}
		return arr;
	}

	/**
	 * function to swap the elements in array.
	 * @param arr the array in which the elements are present.
	 * @param index the position of the first element.
	 * @param min the position of the minimum element.
	 */
	public static void  swap(final int[] arr, final int index,
			final int min) {
        // System.out.println(index + " " + min);
    	int temp = arr[index];
        arr[index] = arr[min];
        arr[min] = temp;
    }
}
