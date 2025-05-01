package ecan;

/**
 * Write a description of WordGram Class here.
 *
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/04/28
 */

public class WordGram {
	private String[] myWords;
	private int myHash;

	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		System.arraycopy(source, start, myWords, 0, size);
	}

	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt " + index);
		}
		return myWords[index];
	}

	public int length() {
		// TODO: Complete this method
		return myWords.length;
	}

	public String toString() {
		String ret = "";
		// TODO: Complete this method
		for (int k = 0; k < myWords.length; k++) {
			ret += myWords[k] + " ";
		}
		return ret.trim();
	}

	public boolean equals(Object o) {
		WordGram other = (WordGram) o;
		// TODO: Complete this method
		if (this.length() != other.length())
			return false;
		for (int k = 0; k < myWords.length; k++) {
			if (!myWords[k].equals(other.wordAt(k))) {
				return false;
			}
		}
		return true;
	}

	public WordGram shiftAdd(String word) {
		// WordGram out = new WordGram(myWords, 0, myWords.length);
		// shift all words one towards 0 and add word at the end.
		// you lose the first word
		// TODO: Complete this method
		String[] newWords = new String[this.length()];
		for (int i = 0; i < newWords.length - 1; i++) {
			newWords[i] = this.wordAt(i + 1);
		}
		newWords[newWords.length - 1] = word;
		WordGram out = new WordGram(newWords, 0, newWords.length);
		return out;
	}

	public int hashCode() {
		return toString().hashCode();
	}

	public static void main(String[] args) {
		System.err.println("WordGram class is not meant to be run");
	}
}
