
/**
 * Write a description of MatchAllFilter here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/28
 */
import java.util.*;

public class MatchAllFilter implements Filter {

	private ArrayList<Filter> filters;

	public MatchAllFilter() {
		filters = new ArrayList<Filter>();
	}

	public void addFilter(Filter f) {
		filters.add(f);
	}

	public boolean satisfies(QuakeEntry qe) {
		for (Filter f : filters) {
			if (!f.satisfies(qe)) {
				return false;
			}
		}
		return true;
	}

	public String getName() {
		StringBuilder name = new StringBuilder();
		// String name = null;
		for (Filter f : filters) {
			System.err.println(f);
			System.err.println(f.getName());
			if (f.getName() != null) {
				name.append(f.getName() + " ");
			}
		}
		return name.toString();
	}
}
