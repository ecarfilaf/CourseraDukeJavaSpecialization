
/**
 * Write a description of DepthFilter here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/28
 */

public class DepthFilter implements  Filter {
	
	private double minDep;
	private double maxDep;
	private String strFilter;

	public DepthFilter (double min, double max, String sName) {
		minDep = min;
		maxDep = max;
		strFilter= sName;
	}
	
	public boolean satisfies(QuakeEntry qe) {
		return qe.getDepth() >= minDep && qe.getDepth() <= maxDep;
	}

	public String getName(){
		return strFilter;
	}

}
