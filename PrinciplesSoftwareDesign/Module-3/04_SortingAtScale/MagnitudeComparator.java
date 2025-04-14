
/**
 * Write a description of class MagnitudeComparator here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/04/03
 */

 import java.util.*;

 public class MagnitudeComparator implements Comparator<QuakeEntry> {
	 public int compare(QuakeEntry qe1, QuakeEntry qe2) {
		 return Double.compare(qe1.getMagnitude(), qe2.getMagnitude());
	 }
	 
 }
 