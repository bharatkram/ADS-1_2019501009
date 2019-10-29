final class Solution {
	private Solution() {
	}
	/**
	 * the main function that runs the program.
	 * @param a the total number of persons in the sequence.
	 * @param b	the person who is to be eliminated.
	 * @return the sequence of elimination.
	 */
	public static String Josephus(final int a, final int b) {

		MyLinkedList seq = new MyLinkedList();
		for (int i = 0; i < a; i++) {
			seq.add(Integer.toString(i));
		}
		seq.join();

		return seq.give(b);
	}
}
