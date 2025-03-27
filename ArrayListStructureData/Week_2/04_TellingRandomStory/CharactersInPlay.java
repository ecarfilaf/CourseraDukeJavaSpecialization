
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/13
 */
import java.util.*;
import edu.duke.*;

public class CharactersInPlay {

	private ArrayList<String> names;
	private ArrayList<Integer> counts;

	public CharactersInPlay() {
		names = new ArrayList<String>();
		counts = new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		System.out.println(".()");
	}

	public void update(String person) {
		int idx = names.indexOf(person);
		if (idx == -1) {
			names.add(person);
			counts.add(1);
		} else {
			int idxCount = counts.get(idx) + 1;
			counts.set(idx, idxCount);
		}
	}

	public void findAllCharacters() {
		FileResource fr = new FileResource();
		String firstOccur = "";
		for (String line : fr.lines()) {
			if (line.indexOf(".") != -1) {
				firstOccur = line.substring(0, line.indexOf("."));
				update(firstOccur);
			}
		}
	}

	public void tester() {
		counts.clear();
		names.clear();
		findAllCharacters();
		for (int i = 0; i < names.size(); i++) {
			if (counts.get(i) > 1) {
				System.out.println(names.get(i) + "\t" + counts.get(i));
			}
		}
		charactersWithNumParts(10,15);
	}

	public void charactersWithNumParts(int num1, int num2) {
		System.out.println("Characters that have between " + num1 + " and " + num2 + " lines:");
		for (int i = 0; i < names.size(); i++) {
			if (counts.get(i) >= num1 && counts.get(i) <= num2) {
				System.out.println(names.get(i) + "\t" + counts.get(i));
			}
		}
	}
}
