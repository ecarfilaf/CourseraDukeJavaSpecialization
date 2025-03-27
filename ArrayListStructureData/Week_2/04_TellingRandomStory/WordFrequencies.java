
/**
 * Write a description of WordFrequencies here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/13
 */
import java.util.*;
import edu.duke.*;

public class WordFrequencies {
	private ArrayList<String> myWords;
	private ArrayList<Integer> myFreqs;

	public static void main(String[] args) {
		System.err.println("");
	}

	public WordFrequencies() {
		myWords = new ArrayList<String>();
		myFreqs = new ArrayList<Integer>();
	}

	public void findUnique() {
		myWords.clear();
		myFreqs.clear();
		FileResource f = new FileResource();
		for (String word : f.words()) {
			word = word.toLowerCase();
			int index = myWords.indexOf(word);
			if (index == -1) {
				myWords.add(word);
				myFreqs.add(1);
			} else {
				int value = myFreqs.get(index);
				myFreqs.set(index, value + 1);
			}
		}
	}

	public void testFindUnique() {
		findUnique();
		System.out.println("Number of unique words: " + myWords.size());
		for (int i = 0; i < myWords.size(); i++) {
			System.out.println(myWords.get(i) + "\t" + myFreqs.get(i));
		}
		findIndexOfMax();
	}

	public void findIndexOfMax(){
		String maxWord = "";
		int maxVal = -1;
		int maxIndex = -1;

		for (int i = 0; i < myFreqs.size(); i++){
			if (myFreqs.get(i) > maxVal){
				maxVal = myFreqs.get(i);
				maxIndex = i;
			}
		}
		maxWord = myWords.get(maxIndex);

		System.out.println("The word that occurs most often and its count are: "+ maxWord +" "+ maxVal );
	}
}
