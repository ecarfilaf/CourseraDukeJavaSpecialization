package ecan;

public class Rating implements Comparable<Rating> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rating r1 = new Rating("Item1", 4.5);
		System.out.println(r1.toString());
	}

	private String item;
	private double value;

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
}
