final class Solution {
	private Solution() {
	}

	/**
	 * function to call pass the array to the sub functions.
	 * boxes and unboxes the array.
	 *
	 * @param arr the array that is being passed.
	 * @return the sorted array.
	 */
	public static int[] quickSort(final int[] arr) {
		sort(arr, 0, arr.length - 1);
		return arr;
	}

	/**
	 * function to sort the array in ascending order recursively.
	 *
	 * @param arr the array to be sorted.
	 * @param lo the starting position of the array.
	 * @param hi the ending position of the array.
	 */
	private static void sort(final int[] arr, final int lo, final int hi) {
		if (hi <= lo) {
			return;
		}
		int j = partition(arr, lo, hi);
		sort(arr, lo, j - 1);
		sort(arr, j + 1, hi);
	}

	/**
	 * function to divide the function based on the pivot position.
	 *
	 * @param arr the array to be sorted.
	 * @param lo the position of the starting element.
	 * @param hi the position of the last element.
	 * @return the
	 */
	private static int partition(final int[] arr, final int lo,
				final int hi) {
		int i = lo;
		int j = hi + 1;
		while (true) {
			while (arr[++i] < arr[lo]) {
				if (i == hi) {
					break;
				}
			}
			while (arr[lo] < arr[--j]) {
				if (j == lo) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

		int temp = arr[lo];
		arr[lo] = arr[j];
		arr[j] = temp;
		return j;
	}
}
