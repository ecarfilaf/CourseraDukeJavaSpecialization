package ecan;

/**
 * Write a description of Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/05/10
 */

public class DirectorsFilter implements Filter {
	private String directors;

	public DirectorsFilter(String directors) {
		this.directors = directors;
	}

	@Override
	public boolean satisfies(String id) {
		String[] dir = directors.split(",");
		// boolean exist = false;
		for (String i : dir) {
			// System.out.println(id + " : " + MovieDatabase.getDirector(id) + " : " + MovieDatabase.getTitle(id));
			if (MovieDatabase.getDirector(id).contains(i)) {
				return true;
				// break;
			}
		}
		return false;
	}
}
