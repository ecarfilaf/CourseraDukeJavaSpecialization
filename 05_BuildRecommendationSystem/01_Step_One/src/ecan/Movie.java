package ecan;

/**
 * Write a description of Movie Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/04/30
 */

public class Movie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie m = new Movie("1", "The Matrix", "1999", "Action, Sci-Fi");
		System.out.println(m.toString());
	}

	private String id;
	private String title;
	private int year;
	private String genres;
	private String director;
	private String country;
	private String poster;
	private int minutes;

	public Movie(String anID, String aTitle, String aYear, String theGenres) {
		// just in case data file contains extra whitespace
		id = anID.trim();
		title = aTitle.trim();
		year = Integer.parseInt(aYear.trim());
		genres = theGenres;
	}

	public Movie(String anID, String aTitle, String aYear, String theGenres, String aDirector,
			String aCountry, String aPoster, int theMinutes) {
		// just in case data file contains extra whitespace
		id = anID.trim();
		title = aTitle.trim();
		year = Integer.parseInt(aYear.trim());
		genres = theGenres;
		director = aDirector;
		country = aCountry;
		poster = aPoster;
		minutes = theMinutes;
	}

	// Returns ID associated with this item
	public String getID() {
		return id;
	}

	// Returns title of this item
	public String getTitle() {
		return title;
	}

	// Returns year in which this item was published
	public int getYear() {
		return year;
	}

	// Returns genres associated with this item
	public String getGenres() {
		return genres;
	}

	public String getCountry() {
		return country;
	}

	public String getDirector() {
		return director;
	}

	public String getPoster() {
		return poster;
	}

	public int getMinutes() {
		return minutes;
	}

	// Returns a string of the item's information
	public String toString() {
		String result = "Movie [id=" + id + ", title=" + title + ", year=" + year;
		result += ", genres= " + genres + "]";
		return result;
	}
}
