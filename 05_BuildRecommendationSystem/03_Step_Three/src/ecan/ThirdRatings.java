package ecan;

/**
 * Write a description of Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/05/06
 */
import java.util.*;

public class ThirdRatings {

	// private ArrayList<Movie> myMovies;
	private ArrayList<Rater> myRaters;

	public ThirdRatings() {
		// default constructor
		this("ratings.csv");
	}

	public ThirdRatings(String string) {
		// TODO Auto-generated constructor stub
		FirstRatings fr = new FirstRatings();
		myRaters = fr.loadRaters(string);
	}

	public int getRaterSize() {
		return myRaters.size();
	}

	public double getAverageByID(String id, int minimalRaters) {
		double total = 0.0;
		int count = 0;
		for (Rater i : myRaters) {
			double rating = i.getRating(id);
			if (rating != -1) {
				count++;
				total += rating;
				//System.out.println(count + " : " + "id = " + i.getID() + " rating " + rating + " ave " + total);
			}
		}
		//System.out.printf("Movie ID : Count : Total : Rating = %-10s%-5d%-7.2f%-7.2f%n", id, count, total, total / count);
		if (count >= minimalRaters)
			return total / count;
		return 0.0;
	}

	public ArrayList<Rating> getAverageRatings(int minimalRaters) {
		ArrayList<Rating> ratingList = new ArrayList<>();
		// must initialize the filter first.
		Filter trueFilter = new TrueFilter();
		for (String i : MovieDatabase.filterBy(trueFilter)) {
			double ave = getAverageByID(i, minimalRaters);
			if (ave > 0)
				ratingList.add(new Rating(i, ave));// item is string id?
		}
		return ratingList;
	}

	public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter f) {
		ArrayList<Rating> ratingList = new ArrayList<>();
		// must initialize the filter first.
		Filter trueFilter = new TrueFilter();
		ArrayList<String> movieID = MovieDatabase.filterBy(trueFilter);

		// for (String i : movieID) {
		// double ave = getAverageByID(i, minimalRaters);
		// if (ave > 0)
		// ratingList.add(new Rating(i, ave));
		// }
		for (String i : movieID) {
			if (f.satisfies(i)) {
				double ave = getAverageByID(i, minimalRaters);
				if (ave > 0)
					ratingList.add(new Rating(i, ave));
			}
		}
		return ratingList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThirdRatings tr = new ThirdRatings("ratings.csv");
		System.out.println("---------------test-------------");
		System.out.println(tr.getAverageRatings(2));
	}

}
