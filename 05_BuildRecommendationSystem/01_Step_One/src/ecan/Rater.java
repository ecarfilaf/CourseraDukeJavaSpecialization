package ecan;

/**
 * Write a description of Rater Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/04/30
 */

import java.util.*;

public class Rater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rater rater = new Rater("12345");
		rater.addRating("Movie1", 4.5);
		System.out.println("Rater ID: " + rater.getID());
	}

	private String myID;
	private ArrayList<Rating> myRatings;

	public Rater(String id) {
		myID = id;
		myRatings = new ArrayList<Rating>();
	}

	public void addRating(String item, double rating) {
		myRatings.add(new Rating(item, rating));
	}

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

	public ArrayList<String> getItemsRated() {
		ArrayList<String> list = new ArrayList<String>();
		for (int k = 0; k < myRatings.size(); k++) {
			list.add(myRatings.get(k).getItem());
		}
		return list;
	}
}
