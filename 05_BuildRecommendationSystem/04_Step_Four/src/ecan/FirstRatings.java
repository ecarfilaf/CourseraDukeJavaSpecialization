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

public class FirstRatings {
	
	private ArrayList<Movie> movies;

	public ArrayList<Movie> loadMovies(String filename) {
		// process every record from csv file
		FileResource fr = new FileResource(filename);
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		for (CSVRecord record : fr.getCSVParser()) {
			Movie currMovie = new Movie(record.get("id"), record.get("title"), record.get("year"), record.get("genre"),
					record.get("director"), record.get("country"), record.get("poster"),
					Integer.parseInt(record.get("minutes")));
			movieList.add(currMovie);
		}
		return movieList;
	}

	public void printMovies(ArrayList<Movie> movies) {
		movies.forEach(movie -> {
			System.out.println(movie.getID() + ", " + movie.getTitle() + ", " + movie.getYear() + ", "
					+ movie.getCountry() + ", " + movie.getGenres() + ", " + movie.getDirector() + ", "
					+ movie.getMinutes() + ", " + movie.getPoster());
		});
		System.out.println("Number of movies printed: " + movies.size());
	} // end printMovies

	public void searchComedy() {
		// Create a new ArrayList to store the movies
		ArrayList<Movie> comedyMovies = new ArrayList<Movie>();

		// Loop through each movie in the list
		for (Movie movie : movies) {
			// Check if the movie is a comedy
			if (movie.getGenres().contains("Comedy")) {
				comedyMovies.add(movie);
			}
		}

		System.out.println("Number of comedy movies: " + comedyMovies.size());
		printMovies(comedyMovies);
	} // end searchComedy

	public void searchMinutes(float min) {
		// Create a new ArrayList to store the movies
		ArrayList<Movie> longMovies = new ArrayList<Movie>();

		// Loop through each movie in the list
		for (Movie movie : movies) {
			// Check if the movie is greater than the given minutes
			if (movie.getMinutes() > min) {
				longMovies.add(movie);
			}
		}

		System.out.println("Number of long movies: " + longMovies.size());
		printMovies(longMovies);
	} // end searchMinutes
	
	public ArrayList<Rater> loadRaters(String filename) {
		FileResource fr = new FileResource(filename);
		//String searchRaterID = "2";

		ArrayList<Rater> raters = new ArrayList<Rater>();
		//ArrayList<String> raterIDList = new ArrayList();

		// find the number of ratings for a particular rater

		for (CSVRecord record : fr.getCSVParser()) {
			String rater_id = record.get("rater_id");
			String movie_id = record.get("movie_id");
			double rating = Double.parseDouble(record.get("rating"));

			if (raters.size() == 0) {
				PlainRater currRater = new PlainRater(rater_id);
				currRater.addRating(movie_id, rating);
				raters.add(currRater);
				//raters.add(new Rater(rater_id));
			} else {
				List<Rater> raterList = new ArrayList<Rater>(raters);
				Iterator<Rater> raterIterator = raterList.iterator();
				while (raterIterator.hasNext()) {
					Rater r = raterIterator.next();
					if (r.getID().equals(rater_id)) {
						r.addRating(movie_id, rating);
						break;
					} else {
						Rater currRater = new PlainRater(rater_id);
						currRater.addRating(movie_id, rating);
						raters.add(currRater);
						break;
					}
				}
			}
		}
		return raters;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstRatings fr = new FirstRatings();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies = fr.loadMovies("../data/ratedmoviesfull.csv");
		fr.printMovies(movies);
	}
}