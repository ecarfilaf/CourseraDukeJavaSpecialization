package ecan;

/**
 * Write a description of Rater Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/04/30
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class FirstRatings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstRatings fr = new FirstRatings();
		// fr.testLoadMovies();
		fr.testLoadRaters();
		// fr.testRatingsByRater();
		// fr.testNumOfRatingPerMovie();
		// fr.testRaterWithNumOfMovies();
		// fr.testLoadMoviesQuest();
		fr.testLoadRatersQuest();
	} // end main

	private ArrayList<Movie> movies = new ArrayList<Movie>();
	private ArrayList<Rater> raters = new ArrayList<>();

	public void loadMovies(String filename) {
		//// Create a new ArrayList to store the movies
		// ArrayList<Movie> movies = new ArrayList<Movie>();

		// Create a new File object for the CSV file
		FileResource fr = new FileResource(filename);

		// Create a new CSVParser object to parse the CSV file
		CSVParser parser = fr.getCSVParser();

		// Loop through each row in the CSV file
		for (CSVRecord record : parser) {
			String id = record.get(0);
			String title = record.get(1);
			String year = record.get(2);
			String country = record.get(3);
			String genres = record.get(4);
			String director = record.get(5);
			int minutes = Integer.parseInt(record.get(6));
			String poster = record.get(7);

			// Create a new Movie object and add it to the list
			movies.add(new Movie(id, title, year, genres, director, country, poster, minutes));
		}

		System.out.println("Number of movies load: " + movies.size());
		// printMovies(movies);
	} // end loadMovies

	public void testLoadMovies() {
		// loadMovies("../data/ratedmovies_short.csv");
		loadMovies("../data/ratedmoviesfull.csv");

		// printMovies(movies);
		// searchComedy();
		// searchMinutes(150);
		countMoviesByDirector();
	} // end testLoadMovies

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

	public void countMoviesByDirector() {
		// Create a new ArrayList to store the directors and num of movies
		HashMap<String, Integer> directedMovies = new HashMap<String, Integer>();

		// Loop through each movie in the list
		for (Movie movie : movies) {

			// Check if the movie is directed by the given director
			if (!directedMovies.containsKey(movie.getDirector())) {
				directedMovies.put(movie.getDirector(), 1);
			} else {
				directedMovies.put(movie.getDirector(), directedMovies.get(movie.getDirector()) + 1);
			}
		}

		// Print the number of movies directed by director
		directedMovies.forEach((key, value) -> {
			System.out.println("Number of movies directed by " + key + ": " + value);
		});
	} // end searchByDirector

	public void loadRaters(String fileName) {
		FileResource fr = new FileResource(fileName);
		CSVParser parser = fr.getCSVParser();
		for (CSVRecord record : parser) {
			String id = record.get("rater_id");
			String movie = record.get("movie_id");
			double value = Double.parseDouble(record.get("rating"));

			int c = 0;
			for (Rater r : raters) {
				if (r.getID().contains(id)) {
					r.addRating(movie, value);
					c++;
				}
			}
			if (c == 0) {
				Rater m = new Rater(id);
				m.addRating(movie, value);
				raters.add(m);
				System.out.println("New rater added! " + id + "\t" + movie + "\t" + value);
			}
		}
		System.out.println("Number of ratings load: " + raters.size());
	}

	public void testLoadRaters() {
		// loadRaters("../data/ratings_short.csv");
		loadRaters("../data/ratings.csv");
	}

	// find the number o f ratings for a particular rater
	public int getRatingsPerRater(ArrayList<Rater> raters, String rater_id) {
		int numOfRatingsPerRater = 0;
		for (Rater currRater : raters) {
			if (currRater.getID().equals(rater_id)) {
				numOfRatingsPerRater += 1;
			}
		}
		return numOfRatingsPerRater;
	}

	public void testRatingsByRater() {
		loadRaters("../data/ratings_short.csv");
		System.out.println("Ratings of rater 2: " + getRatingsPerRater(raters, "2"));
	}

	// find the number of ratings a particular movie has
	public int getNumOfRatingPerMovie(ArrayList<Rater> raters, String movie_id) {
		int numOfRatingPerMovie = 0;
		for (Rater rater : raters) {
			// use method hasRating in class Rater
			if (rater.hasRating(movie_id)) {
				numOfRatingPerMovie += 1;
			}
		}
		return numOfRatingPerMovie;
	}

	public void testNumOfRatingPerMovie() {
		loadRaters("../data/ratings_short.csv");
		System.out.println("Num Of Rating Per Movie 1798709 : " + getNumOfRatingPerMovie(raters, "1798709"));
	}

	// find the maximum number of ratings by any rater
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

	public void testRaterWithNumOfMovies() {
		loadRaters("../data/ratings_short.csv");
		System.out.println("Num Of Rating Per Movie 1798709 : " + getNumOfRatingPerMovie(raters, "1798709"));
	}

	public ArrayList<Movie> loadMoviesQuest(String filename) {
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

	public void testLoadMoviesQuest() {
		// call the method loadMovies on the file ratemovies_short.csv

		ArrayList<Movie> loadedMovies = loadMoviesQuest("../data/ratedmoviesfull.csv");

		System.out.println("number of movies: " + loadedMovies.size());
		System.out.println("loadedMovie: " + loadedMovies);

		int genreCount = 0;
		int moreThan150min = 0;
		HashMap<String, Integer> directorCounts = new HashMap();

		for (int k = 0; k < loadedMovies.size(); k++) {
			Movie currMovie = loadedMovies.get(k);
			// System.out.println(currMovie);
			if (currMovie.getGenres().contains("Comedy")) {
				genreCount++;
			}
			if (currMovie.getMinutes() > 150) {
				moreThan150min++;
			}

			String currDirector = currMovie.getDirector();
			// System.out.println("current director: " + currDirector);

			if (directorCounts.containsKey(currDirector)) {
				directorCounts.put(currDirector, directorCounts.get(currDirector) + 1);
			} else {
				directorCounts.put(currDirector, 1);
			}

			// System.out.println("directorCounts : " + directorCounts);
		}

		int dirWithMaxMovies = Collections.max(directorCounts.values());

		ArrayList<String> movieWithMaxdirs = new ArrayList();
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
		// print the number of movies, and print each movie

	}

	public ArrayList<Rater> loadRatersQuest(String filename) {
		FileResource fr = new FileResource(filename);
		String searchRaterID = "2";

		ArrayList<Rater> raters = new ArrayList<Rater>();
		ArrayList<String> raterIDList = new ArrayList();

		// find the number of ratings for a particular rater

		for (CSVRecord record : fr.getCSVParser()) {
			String rater_id = record.get("rater_id");
			String movie_id = record.get("movie_id");
			double rating = Double.parseDouble(record.get("rating"));

			if (raters.size() == 0) {
				Rater currRater = new Rater(rater_id);
				currRater.addRating(movie_id, rating);
				raters.add(currRater);

			} else {
				List<Rater> raterList = new ArrayList<Rater>(raters);
				Iterator<Rater> raterIterator = raterList.iterator();
				while (raterIterator.hasNext()) {
					Rater r = raterIterator.next();
					if (r.getID().equals(rater_id)) {
						r.addRating(movie_id, rating);
						break;
					} else {
						Rater currRater = new Rater(rater_id);
						currRater.addRating(movie_id, rating);
						raters.add(currRater);
						break;
					}

				}
			}

		}

		return raters;

	}

	public void testLoadRatersQuest() {
		// print the total number of raters
		// ArrayList<Rater> loadedRaters = loadRaters("data/ratings_short.csv");
		ArrayList<Rater> loadedRaters = loadRatersQuest("../data/ratings.csv");

		// find the number of ratings for a particular rater

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

		////////// Find maximum number of ratings ///////////////////////////
		// getRaterWithNumOfMovies(raters,raterWithNumOfMovies);
		int numOfRatingPerMovie = getNumOfRatingPerMovie(loadedRaters, "1798709");
		System.out.println("1798709 has " + numOfRatingPerMovie + " raters");

		//////// how many different movies have been rated by all these raters///////

		HashMap<String, Integer> movieRatingCounts = new HashMap();

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
}