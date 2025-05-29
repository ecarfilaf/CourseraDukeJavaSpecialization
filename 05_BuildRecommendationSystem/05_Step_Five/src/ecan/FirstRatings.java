package ecan;

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

/**
 * Write a description of FirstRatings here.
 * 
 * @author ()
 * @version ()
 */
public class FirstRatings {

	public ArrayList<Movie> loadMovies(String filename) {
		FileResource fr = new FileResource(filename);
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		for (CSVRecord record : fr.getCSVParser()) {
			Movie currMovie = new Movie(record.get("id"), record.get("title"), record.get("year"), record.get("genre"),
					record.get("director"), record.get("country"), record.get("poster"),
					Integer.parseInt(record.get("minutes")));
			;
			movieList.add(currMovie);
		}

		return movieList;
	}

	public void testLoadMovies() {

		ArrayList<Movie> loadedMovies = loadMovies("data/ratedmoviesfull.csv");

		System.out.println("number of movies: " + loadedMovies.size());

		int genreCount = 0;
		int moreThan150min = 0;
		HashMap<String, Integer> directorCounts = new HashMap<String, Integer>();

		for (int k = 0; k < loadedMovies.size(); k++) {
			Movie currMovie = loadedMovies.get(k);

			if (currMovie.getGenres().contains("Comedy")) {
				genreCount++;
			}
			if (currMovie.getMinutes() > 150) {
				moreThan150min++;
			}

			String currDirector = currMovie.getDirector();

			if (directorCounts.containsKey(currDirector)) {
				directorCounts.put(currDirector, directorCounts.get(currDirector) + 1);
			} else {
				directorCounts.put(currDirector, 1);
			}
		}

		int dirWithMaxMovies = Collections.max(directorCounts.values());

		ArrayList<String> movieWithMaxdirs = new ArrayList<String>();
		for (String dir : directorCounts.keySet()) {
			if (directorCounts.get(dir) == dirWithMaxMovies) {
				movieWithMaxdirs.add(dir);
			}
		}

		System.out.println("Director with Max movies: " + dirWithMaxMovies);
		System.out.println("The numbers of Comedy movies: " + genreCount);
		System.out.println("The numbers of movies with more than 150 minutes: " + moreThan150min);
		System.out.println("Max number of movies by a single director: " + dirWithMaxMovies);
		System.out.println("Directors that directed the max number of movies: \n" + movieWithMaxdirs);

	}

	@SuppressWarnings("unused")
	public ArrayList<Rater> loadRaters(String filename) {
		FileResource fr = new FileResource(filename);
		String searchRaterID = "2";
		ArrayList<Rater> raters = new ArrayList<Rater>();
		ArrayList<String> raterIDList = new ArrayList<String>();

		for (CSVRecord record : fr.getCSVParser()) {
			String rater_id = record.get("rater_id");
			String movie_id = record.get("movie_id");
			double rating = Double.parseDouble(record.get("rating"));

			if (raterIDList.contains(rater_id) == true) {
				for (int k = 0; k < raters.size(); k++) {
					Rater currRater = raters.get(k);
					if (currRater.getID().equals(rater_id)) {
						currRater.addRating(movie_id, rating);
						raters.set(k, currRater);
					}
				}
			} else {
				Rater newRater = new EfficientRater(rater_id);
				newRater.addRating(movie_id, rating);
				raters.add(newRater);
				raterIDList.add(rater_id);
			}
		}
		return raters;
	}

	public void testLoadRaters() {
		ArrayList<Rater> loadedRaters = loadRaters("data/ratings.csv");

		System.out.println("loadedRaters size: " + loadedRaters.size());
		int numOfRatingsPerRater = getRatingsPerRater(loadedRaters, "193");
		System.out.println("rater_id:193 has " + numOfRatingsPerRater + " ratings");

		////// Find maximum number of ratings /////////////////
		HashMap<String, Integer> raterWithNumOfMovies = new HashMap<String, Integer>();
		getRaterWithNumOfMovies(loadedRaters, raterWithNumOfMovies);

		int maxValue = Collections.max(raterWithNumOfMovies.values());
		String maxKey = "";
		for (String s : raterWithNumOfMovies.keySet()) {
			if (raterWithNumOfMovies.get(s) == maxValue) {
				maxKey = s;
			}
		}
		System.out.println("maxKey: " + maxKey + ", " + "maxValue: " + maxValue);
		int numOfRatingPerMovie = getNumOfRatingPerMovie(loadedRaters, "1798709");
		System.out.println("1798709 has " + numOfRatingPerMovie + " raters");

		HashMap<String, Integer> movieRatingCounts = new HashMap<String, Integer>();

		for (int k = 0; k < loadedRaters.size(); k++) {
			Rater currRater = loadedRaters.get(k);
			for (int i = 0; i < currRater.numRatings(); i++) {

				String currMovieID = currRater.getItemsRated().get(i);

				if (movieRatingCounts.containsKey(currMovieID)) {
					movieRatingCounts.put(currMovieID, movieRatingCounts.get(currMovieID) + 1);
				} else {
					movieRatingCounts.put(currMovieID, 1);
				}
			}
		}

		System.out.println("number of movies rated: " + movieRatingCounts.size());

	}

	public int getRatingsPerRater(ArrayList<Rater> raters, String rater_id) {
		int numOfRatingsPerRater = 0;
		for (Rater currRater : raters) {
			if (currRater.getID().equals(rater_id)) {
				numOfRatingsPerRater += 1;
			}
		}
		return numOfRatingsPerRater;
	}

	public void getRaterWithNumOfMovies(ArrayList<Rater> raters, HashMap<String, Integer> raterWithNumOfMovies) {
		for (Rater rater : raters) {
			if (!raterWithNumOfMovies.containsKey(rater.getID())) {
				raterWithNumOfMovies.put(rater.getID(), 1);
			} else {
				int num = raterWithNumOfMovies.get(rater.getID());
				num += 1;
				raterWithNumOfMovies.put(rater.getID(), num);
			}
		}
	}

	public int getNumOfRatingPerMovie(ArrayList<Rater> raters, String movie_id) {
		int numOfRatingPerMovie = 0;
		for (Rater rater : raters) {
			if (rater.hasRating(movie_id)) {
				numOfRatingPerMovie += 1;
			}
		}
		return numOfRatingPerMovie;
	}

}