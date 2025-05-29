package ecan;

/**
 * Write a description of Movie Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/05/06
 */

import java.util.*;

public class AllFilters implements Filter {
	ArrayList<Filter> filters;

	public AllFilters() {
		filters = new ArrayList<Filter>();
	}

	public void addFilter(Filter f) {
		filters.add(f);
	}

	@Override
	public boolean satisfies(String id) {
		for (Filter f : filters) {
			if (!f.satisfies(id)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
