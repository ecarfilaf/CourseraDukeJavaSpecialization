
/**
 * Write a description of WordLengths here.
 * 
 * @author Esteban Carfilaf 
 * @version 1.001.01 2025/03/11
 */
import edu.duke.*;

public class WordLengths {
	public static void main(String[] args) {
		System.out.println(".()");
	}

	public boolean isLetter(char c) {
		String vowels = "abcdefghijklmnopqrstuvwxyz'";
		char lowerCh = Character.toLowerCase(c);
		return vowels.indexOf(lowerCh) != -1;
	}

	public String isWordString(String s) {
		String word = "";
		for (int i = 0; i < s.length(); i++) {
			if (isLetter(s.charAt(i))) {
				word = word + s.charAt(i);
			}
		}
		return word;
	}

	public void countWordLengths(FileResource fr, int[] counts) {
		for (String s : fr.words()) {
			String s2 = isWordString(s);
			int l = s2.length();
			counts[l - 1] += 1;
		}
	}

	public void testCountWordLengths() {
		FileResource fr = new FileResource();
		int[] counts = new int[31];
		countWordLengths(fr, counts);
		for (int i = 0; i < counts.length; i++) {
			System.out.println((i + 1) + ": " + counts[i]);
		}
	}

}
