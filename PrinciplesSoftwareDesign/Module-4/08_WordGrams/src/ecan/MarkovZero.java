package ecan;

/**
 * Write a description of WordGram Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/04/29
 */
import java.util.*;

public class MarkovZero implements IMarkovModel {
	private String myText;
	private Random myRandom;

	public MarkovZero() {
		myRandom = new Random();
	}

	public void setRandom(int seed) {
		myRandom = new Random(seed);
	}

	public void setTraining(String s) {
		myText = s.trim();
	}

	public String getRandomText(int numChars) {
		if (myText == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < numChars; k++) {
			int index = myRandom.nextInt(myText.length());
			sb.append(myText.charAt(index));
		}
		return sb.toString();
	}
}