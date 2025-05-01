package ecan;

/**
 * Write a description of MarkovWord class here.
 *
 * @author Esteban Carfilaf 
 * @version 1.001.01 2025/04/28
 */

import java.util.*;

public class MarkovWord implements IMarkovModel {

	private String[] myText;
	private Random myRandom;
	private int myOrder;

	public MarkovWord(int order) {
		myRandom = new Random();
		myOrder = order;
	}

	public void setRandom(int seed) {
		myRandom = new Random(seed);
	}

	public void setTraining(String text) {
		myText = text.split("\\s+");
	}

	public String toString() {
		return "MarkovWord of order " + myOrder;
	}

	public String getRandomText(int numWords) {
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length - myOrder);
		String[] initialKeys = new String[myOrder];
		for (int k = 0; k < myOrder; k++) {
			initialKeys[k] = myText[index + k];
			sb.append(initialKeys[k]).append(" ");
		}
		WordGram key = new WordGram(initialKeys, 0, initialKeys.length);

		for (int k = 0; k < numWords - myOrder; k++) {
			ArrayList<String> follows = getFollows(key);
			// System.out.println(key+": "+follows);
			if (follows.size() == 0) {
				break;
			}
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key = key.shiftAdd(next);
		}

		return sb.toString().trim();
	}

	private static int indexOf(String[] words, WordGram target, int start) {
		for (int k = start; k <= words.length - target.length(); k++) {
			WordGram wg = new WordGram(words, k, target.length());
			if (wg.equals(target)) {
				return k;
			}
		}
		return -1;
	}

	private ArrayList<String> getFollows(WordGram kGram) {
		ArrayList<String> follows = new ArrayList<String>();
		int pos = 0;
		int kGramLength = kGram.length();
		while (pos < myText.length - kGramLength) {
			int start = indexOf(myText, kGram, pos);
			if (start == -1)
				break;
			if (start + kGramLength >= myText.length)
				break;
			follows.add(myText[start + kGramLength]);
			pos = start + kGramLength;
		}
		return follows;
	}

}
