
/**
 * Write a description of MarkovOne here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/27
 */
import java.util.*;

public class MarkovOne {
	private String myText;
	private Random myRandom;

	public MarkovOne() {
		myRandom = new Random();
	}

	public void setRandom(int seed) {
		myRandom = new Random(seed);
	}

	public void setTraining(String s) {
		myText = s.trim();
	}

	public String getRandomText(int numChars) {
		StringBuffer sb = new StringBuffer();
		// We'll generate a random key from the file provided.
		int index = myRandom.nextInt(myText.length() - 1);
		String key = myText.substring(index, index + 1);
		sb.append(key);
		for (int i = 0; i < numChars - 1; i++) {
			ArrayList<String> follows = getFollows(key);
			if (follows.size() == 0) {
				break;
			}
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			key = next;
		}
		return sb.toString();
	}

	public ArrayList<String> getFollows(String key) {
		ArrayList<String> follows = new ArrayList<String>();
		// String phrase = "this is a test yes this is a test.";
		int pos = 0;
		while (pos < myText.length()) {
			int start = myText.indexOf(key, pos);
			if (start == -1) {
				break;
			}
			if (start + key.length() >= myText.length()) {
				break;
			}
			String next = myText.substring(start + key.length(), start + key.length() + 1);
			follows.add(next);
			pos = start + key.length();
		}
		return follows;
	}
}