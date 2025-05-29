package ecan;

/**
 * Write a description of Movie Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/05/02
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class SecondRatings {

	private ArrayList<Movie> myMovies;
	private ArrayList<Rater> myRaters;

	public SecondRatings() {
		// default constructor
		this("ratedmoviesfull.csv", "ratings.csv");
	}

	public SecondRatings(String string, String string2) {
		// TODO Auto-generated constructor stub
		FirstRatings fr = new FirstRatings();
		myMovies = fr.loadMovies(string);
		myRaters = fr.loadRaters(string2);
	}

	public int getMovieSize() {
		return myMovies.size();
	}

	public int getRaterSize() {
		return myRaters.size();
	}

	public double  getAverageByID(String id, int minimalRaters) {
		double total = 0.0;
		int count = 0;
		for (int i = 0; i < myRaters.size(); i++) {
			Rater r = myRaters.get(i);
			if (r.hasRating(id)) {
				count++;
				total += r.getRating(id);
			}
		}
		if (count >= minimalRaters) {
			return total / count;
		} else {
			return 0.0;
		}
	}

	public ArrayList<Rating> getAverageRatings(int minimalRaters) {
		ArrayList<Rating> movieList = new ArrayList<Rating>();
		for (int i = 0; i < myMovies.size(); i++) {
			Movie m = myMovies.get(i);
			String title = m.getTitle();
			double avg = getAverageByID(m.getID(), minimalRaters);
			if (avg != 0.0) {
				//movieList.add(title + " " + avg);
				movieList.add(new Rating(title,avg));
			}
		}
		return movieList;
	}

	public String getTitle(String id) {
		for (int i = 0; i < myMovies.size(); i++) {
			Movie m = myMovies.get(i);
			if (m.getID().equals(id)) {
				return m.getTitle();
			}
		}
		return "Movie not found";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecondRatings sr = new SecondRatings("../data/ratedmoviesfull.csv", "../data/ratings.csv");
		System.out.println(sr.getAverageRatings(10));
	}
}