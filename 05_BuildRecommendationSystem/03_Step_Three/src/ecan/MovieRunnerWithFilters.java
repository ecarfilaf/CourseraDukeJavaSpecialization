package ecan;

/**
 * Write a description of Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/05/07
 */

import java.util.*;

public class MovieRunnerWithFilters {

	public void printAverageRatings() {
		ThirdRatings tr = new ThirdRatings("../data/ratings.csv");
		// System.out.println("Number of movies: " + tr.getMovieSize());
		MovieDatabase.initialize("../data/ratedmoviesfull.csv");
		System.out.println("Number of movies: " + MovieDatabase.size());

		System.out.println("Number of raters: " + tr.getRaterSize());

		ArrayList<Rating> ratingList = new ArrayList<Rating>();
		ratingList = tr.getAverageRatings(35);
		Collections.sort(ratingList, new Comparator<Rating>() {
			public int compare(Rating r1, Rating r2) {
				return Double.compare(r1.getValue(), r2.getValue());
			}
		});

		for (Rating s : ratingList) {
			// System.out.println(s);
			System.out.println(s.getValue() + ", " + MovieDatabase.getTitle(s.getItem()));
		}
		System.out.println(ratingList.size());
	}

	public void printAverageRatingsPerYear() {
		ThirdRatings tr = new ThirdRatings("../data/ratings.csv");
		// System.out.println("Number of movies: " + tr.getMovieSize());
		MovieDatabase.initialize("../data/ratedmoviesfull.csv");
		System.out.println("Number of movies: " + MovieDatabase.size());

		System.out.println("Number of raters: " + tr.getRaterSize());

		System.out.println("---------------------------------------");
		ArrayList<Rating> ratingList = new ArrayList<Rating>();
		ratingList = tr.getAverageRatingsByFilter(20, new YearAfterFilter(2000));
		Collections.sort(ratingList, new Comparator<Rating>() {
			public int compare(Rating r1, Rating r2) {
				return Double.compare(r1.getValue(), r2.getValue());
			}
		});

		for (Rating s : ratingList) {
			// System.out.println(s);
			System.out.println(s.getValue() + ", " + MovieDatabase.getTitle(s.getItem()));
		}
		System.out.println(ratingList.size());
	}

	public void printAverageRatingsByGenre() {
		ThirdRatings tr = new ThirdRatings("../data/ratings.csv");
		// System.out.println("Number of movies: " + tr.getMovieSize());
		MovieDatabase.initialize("../data/ratedmoviesfull.csv");
		System.out.println("Number of movies: " + MovieDatabase.size());

		System.out.println("Number of raters: " + tr.getRaterSize());

		ArrayList<Rating> ratingList = new ArrayList<Rating>();
		ratingList = tr.getAverageRatingsByFilter(20, new GenreFilter("Comedy"));
		Collections.sort(ratingList, new Comparator<Rating>() {
			public int compare(Rating r1, Rating r2) {
				return Double.compare(r1.getValue(), r2.getValue());
			}
		});

		for (Rating s : ratingList) {
			// System.out.println(s);
			System.out.println(s.getValue() + "; " + MovieDatabase.getTitle(s.getItem()) + "; "
					+ MovieDatabase.getGenres(s.getItem()));
		}
		System.out.println("Movies found : " + ratingList.size());
	}

	public void printAverageRatingsByMinutes() {
		ThirdRatings tr = new ThirdRatings("../data/ratings.csv");
		// System.out.println("Number of movies: " + tr.getMovieSize());
		MovieDatabase.initialize("../data/ratedmoviesfull.csv");
		System.out.println("Number of movies: " + MovieDatabase.size());

		System.out.println("Number of raters: " + tr.getRaterSize());

		ArrayList<Rating> ratingList = new ArrayList<Rating>();
		ratingList = tr.getAverageRatingsByFilter(5, new MinutesFilter(105, 135));
		Collections.sort(ratingList, new Comparator<Rating>() {
			public int compare(Rating r1, Rating r2) {
				return Double.compare(r1.getValue(), r2.getValue());
			}
		});

		for (Rating s : ratingList) {
			// System.out.println(s);
			System.out.println(s.getValue() + "; " + MovieDatabase.getTitle(s.getItem()) + "; tiempo = "
					+ MovieDatabase.getMinutes(s.getItem()));
		}
		System.out.println("Movies found : " + ratingList.size());
	}

	public void printAverageRatingsByDirectors() {
		ThirdRatings tr = new ThirdRatings("../data/ratings.csv");
		// System.out.println("Number of movies: " + tr.getMovieSize());
		MovieDatabase.initialize("../data/ratedmoviesfull.csv");
		System.out.println("Number of movies: " + MovieDatabase.size());

		System.out.println("Number of raters: " + tr.getRaterSize());

		ArrayList<Rating> ratingList = new ArrayList<Rating>();
		ratingList = tr.getAverageRatingsByFilter(4, new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"));
		Collections.sort(ratingList, new Comparator<Rating>() {
			public int compare(Rating r1, Rating r2) {
				return Double.compare(r1.getValue(), r2.getValue());
			}
		});

		for (Rating s : ratingList) {
			// System.out.println(s);
			System.out.println(s.getValue() + "; " + MovieDatabase.getTitle(s.getItem()) + "; "
					+ MovieDatabase.getDirector(s.getItem()));
		}
		System.out.println("Movies found : " + ratingList.size());
	}

	public void printAverageRatingsByYearAfterAndGenre() {
		ThirdRatings tr5 = new ThirdRatings("../data/ratings.csv");// do i need put filename here?
		MovieDatabase.initialize("../data/ratedmoviesfull.csv");
		System.out.println("Movie size (# of movie in list) : " + MovieDatabase.size());// need initialize first.
		System.out.println("Rater size (# of ppl who rates) : " + tr5.getRaterSize());
		// why here must use AllFilters instead of Filter?
		AllFilters all = new AllFilters();
		all.addFilter(new GenreFilter("Drama"));
		all.addFilter(new YearAfterFilter(1990));

		ArrayList<Rating> ratingList = tr5.getAverageRatingsByFilter(8, all);
		System.out.println("Found ratings for movies : " + ratingList.size());
		Collections.sort(ratingList, new Comparator<Rating>() {
			public int compare(Rating r1, Rating r2) {
				return Double.compare(r1.getValue(), r2.getValue());
			}
		});
		for (Rating i : ratingList) {
			System.out.printf("%-10.2f%-10d%-16s%-5s%n", i.getValue(), MovieDatabase.getYear(i.getItem()),
					MovieDatabase.getTitle(i.getItem()), MovieDatabase.getGenres(i.getItem()));
		}
		System.out.println("Movies found : " + ratingList.size());
	}

	public void printAverageRatingsByDirectorsAndMinutes() {
		ThirdRatings tr5 = new ThirdRatings("../data/ratings.csv");// do i need put filename here?
		MovieDatabase.initialize("../data/ratedmoviesfull.csv");
		System.out.println("Movie size (# of movie in list) : " + MovieDatabase.size());// need initialize first.
		System.out.println("Rater size (# of ppl who rates) : " + tr5.getRaterSize());
		// why here must use AllFilters instead of Filter?
		AllFilters all = new AllFilters();
		all.addFilter(new MinutesFilter(90, 180));
		all.addFilter(new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));

		ArrayList<Rating> ratingList = tr5.getAverageRatingsByFilter(3, all);
		System.out.println("Found ratings for movies : " + ratingList.size());
		Collections.sort(ratingList, new Comparator<Rating>() {
			public int compare(Rating r1, Rating r2) {
				return Double.compare(r1.getValue(), r2.getValue());
			}
		});
		for (Rating i : ratingList) {
			System.out.printf("%-10.2fTime:%-10s%-16s%-5s%n", i.getValue(), MovieDatabase.getMinutes(i.getItem()),
					MovieDatabase.getTitle(i.getItem()), MovieDatabase.getDirector(i.getItem()));
		}
		System.out.println("Movies found : " + ratingList.size());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieRunnerWithFilters mra = new MovieRunnerWithFilters();
		//mra.printAverageRatings();
		//mra.printAverageRatingsPerYear();
		//mra.printAverageRatingsByGenre();
		//mra.printAverageRatingsByMinutes();
		mra.printAverageRatingsByDirectors();
		//mra.printAverageRatingsByYearAfterAndGenre();
		//mra.printAverageRatingsByDirectorsAndMinutes();
	}

}
