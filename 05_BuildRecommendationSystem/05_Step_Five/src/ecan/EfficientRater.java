package ecan;

/**
 * Write a description of class here.
 * 
 * @author () 
 * @version ()
 */

import java.util.*;

public class EfficientRater implements Rater {
	private String myID;

	private HashMap<String, Rating> myRatings;

	public EfficientRater(String id) {
		myID = id;
		myRatings = new HashMap<String, Rating>();
	}

	public void addRating(String item, double rating) {
		myRatings.put(item, (new Rating(item, rating)));
	}

	public boolean hasRating(String item) {
		return myRatings.containsKey(item);
	}

	public String getID() {
		return myID;
	}

	public double getRating(String item) {
		if (hasRating(item)) {
			return myRatings.get(item).getValue();
		} else {
			return -1;
		}
	}

	public int numRatings() {
		return myRatings.size();
	}

	public ArrayList<String> getItemsRated() {
		ArrayList<String> list = new ArrayList<String>();

		for (String movieID : myRatings.keySet()) {
			list.add(movieID);
		}

		return list;
	}
}
