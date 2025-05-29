package ecan;

/**
 * Write a description of Movie Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/05/06
 */

public class YearAfterFilter  implements Filter {
	private int myYear;
	
	public YearAfterFilter(int year) {
		myYear = year;
	}
	
	@Override
	public boolean satisfies(String id) {
		return MovieDatabase.getYear(id) >= myYear;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
