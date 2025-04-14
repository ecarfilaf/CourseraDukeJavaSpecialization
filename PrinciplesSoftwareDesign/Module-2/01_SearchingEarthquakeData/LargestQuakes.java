
/**
 * Write a description of LargestQuakes here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/27
 */
import java.util.*;

public class LargestQuakes {

	public static void main(String[] args) {
		System.out.println(".()");
	}

	public void findLargestQuakes (){
		EarthQuakeParser parser = new EarthQuakeParser();

		//String source = "data/nov20quakedatasmall.atom";
		String source = "data/nov20quakedata.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes");
		
		//EarthQuakeClient eq = new EarthQuakeClient();
		// ArrayList<QuakeEntry> listed = eq.filterByPhrase(list, "California", "end");
		for (QuakeEntry qe : list) {
			System.out.println(qe);
		}
		System.out.println("Found " + list.size() + " filter quakes");

		int idx = 0;
		idx = indexOfLargest(list);
		System.out.println("Index of Max Quake =  " + idx);
	}

	public int indexOfLargest (ArrayList<QuakeEntry> quakeData){
		int i = 0;
		int idx = -1;
		double maxQuake = -1.0;
		for (QuakeEntry qe : quakeData) {
			if(qe.getMagnitude() > maxQuake){
				maxQuake = qe.getMagnitude();
				idx = i;
			}
			i++;
		}
		return  idx;
	}

	public ArrayList<QuakeEntry> getLargest (ArrayList<QuakeEntry> quakeData, int howMany){
		ArrayList<QuakeEntry> list = new ArrayList<QuakeEntry>();
		ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
		int idx = -1;
		double maxQuake = -1.0;
		for (int i = 0; i < howMany; i++) {
			idx = indexOfLargest(copy);
			list.add(copy.get(idx));
			copy.remove(idx);
		}
		return  list;
	}

	public void testGetLargets(){
		EarthQuakeParser parser = new EarthQuakeParser();

		//String source = "data/nov20quakedatasmall.atom";
		String source = "data/nov20quakedata.atom";
		ArrayList<QuakeEntry> list = parser.read(source);
		System.out.println("read data for " + list.size() + " quakes");
		
		ArrayList<QuakeEntry> listed = getLargest(list, 5);
		for (QuakeEntry qe : listed) {
			System.err.println(qe);
		}
	}
}
