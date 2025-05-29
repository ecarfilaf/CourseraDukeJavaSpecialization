package ecan;

/**
 * Write a description of Movie Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/05/06
 */

import java.util.*;

public class EfficientRater {

	private String myID;
	private HashMap<String, Rating> myRatings;

	public EfficientRater(String id) {
		myID = id;
		myRatings = new HashMap<String, Rating>();
	}

	public void addRating(String item, double rating) {
		//myRatings.add(new Rating(item, rating));
		myRatings.put(item, new Rating(item, rating));
	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean hasRating(String item) {
		for (int k = 0; k < myRatings.size(); k++) {
			if (myRatings.get(k).getItem().equals(item)) {
				return true;
			}
		}

		return false;
	}

	public String getID() {
		return myID;
	}

	@SuppressWarnings("unlikely-arg-type")
	public double getRating(String item) {
		for (int k = 0; k < myRatings.size(); k++) {
			if (myRatings.get(k).getItem().equals(item)) {
				return myRatings.get(k).getValue();
			}
		}

		return -1;
	}

	public int numRatings() {
		return myRatings.size();
	}

	@SuppressWarnings("unlikely-arg-type")
	public ArrayList<String> getItemsRated() {
		ArrayList<String> list = new ArrayList<String>();
		for (int k = 0; k < myRatings.size(); k++) {
			list.add(myRatings.get(k).getItem());
		}

		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
