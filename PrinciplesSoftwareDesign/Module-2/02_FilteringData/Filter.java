
/**
 * Write a description of interface Filter here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/28
 */

public interface Filter {
	public boolean satisfies(QuakeEntry qe);
	
	public String getName();
}
