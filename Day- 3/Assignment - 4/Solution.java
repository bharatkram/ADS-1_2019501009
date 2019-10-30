class Solution {
	/**
	 * the function to sort the teams in the descending order.
	 * Time complexity is (N^2).
	 * @param teams the array that is to be sorted.
	 * @return the sorted array.
	 */
	public Team[] sort(final Team[] teams) {
		for (int i = 1; i < teams.length; i++) {
			for (int j = i; j > 0; j--) {
				if (teams[j].compareTo(teams[j - 1]) >= 0) {
					swap(teams, j - 1, j);
				}
			}
		}
		return teams;
	}

	/**
	 * function to swap the elements in array.
	 * @param arr the array in which the elements are present.
	 * @param index the position of the first element.
	 * @param min the position of the minimum element.
	 */
	public static void  swap(final Team[] arr, final int index,
			final int min) {
        // System.out.println(index + " " + min);
    	Team temp = arr[index];
        arr[index] = arr[min];
        arr[min] = temp;
    }
}
class Team implements Comparable<Team> {
	/**
	 * field to store the name of the team.
	 */
	private String teamName;

	/**
	 * field to store the number of wins for the team.
	 */
	private int noOfWins;

	/**
	 * field to store the number of losses for the team.
	 */
	private int noOfLosses;

	/**
	 * field to store the number of draws for the team.
	 */
	private int noOfDraws;

	Team(final String name, final int wins, final int losses,
			final int draws) {
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}

	/**
	 * the function to print the team details in form of string.
	 *
	 * @return the fields of the team in String format.
	 */
	public String toString() {
		String output = "";
		output += this.teamName + ", " + this.noOfWins + ", "
				+ this.noOfLosses + ", " + this.noOfDraws;
		//retrun all the attributes as a string but appending with ", "
        return output;
	}

	/**
	 * the functio to compare two teams in the array.
	 *
	 * @param that team that is to be compared to.
	 * @return the difference between the fields of two teams.
	 */
	public int compareTo(final Team that) {
		if (this.noOfWins != that.noOfWins) {
			return this.noOfWins - that.noOfWins;
		} else if (this.noOfLosses != that.noOfLosses) {
			return that.noOfLosses - this.noOfLosses;
		} else {
			return this.noOfDraws - that.noOfDraws;
		}
	}
}
