
/**
 * Write a description of WordsInFiles here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/15
 */
import java.io.File;
import java.util.*;
import edu.duke.*;

public class WordsInFiles {
	private HashMap<String, ArrayList> hashWords;

	private int totalWords;

	public WordsInFiles() {
		hashWords = new HashMap<String, ArrayList>();
		totalWords = 0;
	}

	private void addWordsFromFile(File f) {
		FileResource fr = new FileResource(f);
		for (String word : fr.words()) {
			totalWords += 1;
			if (!hashWords.containsKey(word)) {
				ArrayList<String> sourceF = new ArrayList<String>();
				sourceF.add(f.getName());
				hashWords.put(word, sourceF);
			} else {
				ArrayList<String> sourceF = new ArrayList<String>();
				sourceF = hashWords.get(word);
				if (!sourceF.contains(f.getName())) {
					sourceF.add(f.getName());
				}
			}
		}
	}

	public void buildWordFileMap() {
		hashWords.clear();
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			addWordsFromFile(f);
		}
	}

	public int maxNumber() {
		int maxSize = 0;
		for (ArrayList s : hashWords.values()) {
			if (s.size() > maxSize) {
				maxSize = s.size();
			}
		}
		return maxSize;
	}

	public ArrayList wordsInNumFiles(int number) {
		System.out.println("\nThis words appear " + number + " times: ");
		ArrayList<String> words = new ArrayList<String>();
		int counting = 0;
		for (String word : hashWords.keySet()) {
			int counts = hashWords.get(word).size();
			if (counts == number) {
				words.add(word);
				counting++;
			}
		}
		System.out.println("total of words repeated " + number + " times: " + counting);
		return words;
	}

	public void printFilesIn(String word) {
		System.out.println("\nThe word " + word + " is in the following files: ");
		for (String s : hashWords.keySet()) {
			if (s.equals(word)) {
				ArrayList wordAndFiles = hashWords.get(s);
				for (int i = 0; i < wordAndFiles.size(); i++) {
					System.out.println(wordAndFiles.get(i));
				}
			}
		}
	}

	public void tester() {
		buildWordFileMap();
		ArrayList wordsInNumFiles = wordsInNumFiles(5);
		for (int i = 0; i < wordsInNumFiles.size(); i++) {
			System.out.println(wordsInNumFiles.get(i));
		}
		System.out.println("\nMaximum number of words in all the files given = " + maxNumber());
		printFilesIn("tree");
		System.out.println("\n");
		for (String s : hashWords.keySet()) {
			System.out.println(s + hashWords.get(s));
		}
		System.out.println("\nTotal of words in all the files given = " + totalWords);
	}
}
