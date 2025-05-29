package ecan;
/**
 * Write a description of Movie Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/05/02
 */

public class Rating implements Comparable<Rating> {

	private double value;
	private String item;

	public Rating(String anItem, double aValue) {
		item = anItem;
		value = aValue;
	}

	// Returns item being rated
	public String getItem() {
		return item;
	}

	// Returns the value of this rating (as a number so it can be used in
	// calculations)
	public double getValue() {
		return value;
	}

	// Returns a string of all the rating information
	public String toString() {
		return "[" + getItem() + ", " + getValue() + "]";
	}

	public int compareTo(Rating other) {
		if (value < other.value)
			return -1;
		if (value > other.value)
			return 1;

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
