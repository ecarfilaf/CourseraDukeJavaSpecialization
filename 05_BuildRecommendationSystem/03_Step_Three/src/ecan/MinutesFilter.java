package ecan;

/**
 * Write a description of Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/05/10
 */

public class MinutesFilter implements Filter {
	private int min;
	private int max;

	public MinutesFilter(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean satisfies(String id) {
		return MovieDatabase.getMinutes(id) >= min && MovieDatabase.getMinutes(id) <= max;
	}
}
