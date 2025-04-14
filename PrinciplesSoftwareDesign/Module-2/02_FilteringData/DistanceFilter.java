
/**
 * Write a description of DistanceFilter here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/28
 */

public class DistanceFilter implements Filter {

	private Location location;
	private double maxDis;
	private String strFilter;

	public DistanceFilter(Location loc, double distance, String name) {
		location = loc;
		maxDis = distance;
		strFilter = name;
	}

	public boolean satisfies(QuakeEntry qe) {
		return qe.getLocation().distanceTo(location) < maxDis;
	}

	public String getName() {
		return strFilter;
	}

}
