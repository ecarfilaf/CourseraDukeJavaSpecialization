
/**
 * Write a description of class MinMaxFilter here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/28
 */

public class MinMagFilter implements Filter {
	private double magMin;

	public MinMagFilter(double min) {
		magMin = min;
	}

	public boolean satisfies(QuakeEntry qe) {
		return qe.getMagnitude() >= magMin;
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
