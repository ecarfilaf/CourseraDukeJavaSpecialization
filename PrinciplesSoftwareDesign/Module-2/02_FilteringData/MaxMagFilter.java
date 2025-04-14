
/**
 * Write a description of class MinMaxFilter here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/28
 */

public class MaxMagFilter implements Filter {
	private double magMax;

	public MaxMagFilter(double max) {
		magMax = max;
	}

	public boolean satisfies(QuakeEntry qe) {
		return qe.getMagnitude() <= magMax;
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
