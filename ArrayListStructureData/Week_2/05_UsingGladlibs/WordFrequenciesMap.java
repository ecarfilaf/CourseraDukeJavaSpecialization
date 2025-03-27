
/**
 * Write a description of WordFrequenciesMap here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/14
 */
import java.util.*;
import edu.duke.*;

public class WordFrequenciesMap {
	public static void main(String[] args) {
		System.err.println("");
	}

	public void countWords(){
		FileResource fr = new FileResource();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int total = 0;
		for (String w: fr.words()){
			w = w.toLowerCase();
			if (map.keySet().contains(w)){
				map.put(w, map.get(w+1));
			}else{
				map.put(w, 1);
			}
		}
		System.out.println("Total = "+total);
	}
}
