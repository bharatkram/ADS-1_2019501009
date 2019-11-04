class Solution{
	public static boolean isMinHeap(double[] arr){
		if (arr.length == 0) {
			return false;
		}
		double[] temp = new double[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			temp[i + 1] = arr[i];
		}
		for (int i = 1; i < temp.length / 2; i++) {
			if(temp[i] > temp[i * 2]) {
				return false;
			}
		}
		return true;
	}
}