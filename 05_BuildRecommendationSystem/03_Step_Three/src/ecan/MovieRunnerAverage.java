package ecan;
/**
 * Write a description of Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/05/02
 */

import java.util.*;

public class MovieRunnerAverage {

	public void printAverageRatings() {
		SecondRatings sr = new SecondRatings("../data/ratedmoviesfull.csv", "../data/ratings.csv");
		System.out.println("Number of movies: " + sr.getMovieSize());
		System.out.println("Number of raters: " + sr.getRaterSize());

		ArrayList<Rating> movieList = new ArrayList<Rating>(); 
		movieList = sr.getAverageRatings(12);
		movieList = getSortList(movieList);
		for (Rating s : movieList) {
			//System.out.println(s);
			System.out.println(s.getValue() + ", " + s.getItem());
		}
		System.out.println(movieList.size());
	}
	
	public ArrayList<Rating> getSortList(ArrayList<Rating> list) {
		//Collections.sort(list);
		Collections.sort(list, new Comparator<Rating>() {
			public int compare(Rating r1, Rating r2) {
				return Double.compare(r1.getValue(), r2.getValue());
			}
		});
		return list;
	}

	public void getAverageRatingOneMovie() {
		SecondRatings sr = new SecondRatings("../data/ratedmoviesfull.csv", "../data/ratings.csv");
		System.out.println("Number of movies: " + sr.getMovieSize());
		System.out.println("Number of raters: " + sr.getRaterSize());
		
		String id = "0068646"; // Example movie ID

		double rating = sr.getAverageByID(id, 3);
		System.out.println("The average rating for the movie : " + sr.getTitle(id) + " ,is: " + rating);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MovieRunnerAverage mra = new MovieRunnerAverage();
		mra.printAverageRatings();
		//mra.getAverageRatingOneMovie();
	}
}
