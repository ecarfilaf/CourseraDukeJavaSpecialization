
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/28
 */

public class MagnitudeFilter implements Filter {
	
	private double min;
	private double max;
	private String filter;

	public MagnitudeFilter (double minMag, double maxMag, String name) {
		min = minMag;
		max = maxMag;
		filter = name;
	}
	
	public boolean satisfies(QuakeEntry qe) {
		return qe.getMagnitude() >= min && qe.getMagnitude() <= max;
	}

	public String getName(){
		return filter;
	}

}
