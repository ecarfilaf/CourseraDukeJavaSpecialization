package ecan;

/**
 * Write a description of GenreFilter Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/05/09
 */

public class GenreFilter implements Filter {
	private String genre;

	public GenreFilter(String genre) {
		this.genre = genre;
	}

	@Override
	public boolean satisfies(String id) {
		return MovieDatabase.getGenres(id).contains(genre);
	}
}
