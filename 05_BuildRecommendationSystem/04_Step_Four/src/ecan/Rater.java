package ecan;

/**
 * Write a description of Movie Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/05/06
 */
import java.util.*;

public interface Rater {

	public void addRating(String item, double rating);

	public boolean hasRating(String item);

	public String getID();

	public double getRating(String item);

	public int numRatings();

	public ArrayList<String> getItemsRated();
}
