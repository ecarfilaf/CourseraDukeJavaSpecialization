
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

public class MarkovRunnerWithInterface {
	public void runModel(IMarkovModel markov, String text, int size, int seed) {
		markov.setTraining(text);
		markov.setRandom(seed);
		System.out.println("running with " + markov);
		for (int k = 0; k < 3; k++) {
			String st = markov.getRandomText(size);
			printOut(st);
		}
	}

	public void runMarkov() {
		FileResource fr = new FileResource("../data/romeo.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;
		int seed = 953;

		/*
		 * MarkovZero mz = new MarkovZero();
		 * runModel(mz, st, size, seed);
		 */

		/*
		 * MarkovOne mOne = new MarkovOne();
		 * runModel(mOne, st, size, seed);
		 */
		
		 MarkovFour mFour = new MarkovFour();
		 runModel(mFour, st, size, seed);
		 

		/*MarkovOne mThree = new MarkovOne();
		runModel(mThree, st, size, seed);
		*/

	}

	public void testHashMap() {
		FileResource fr = new FileResource("../data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		// String st = "yes-this-is-a-thin-pretty-pink-thistle";
		int size = 50;
		int seed = 792;
		EfficientMarkovModel mod = new EfficientMarkovModel(6);
		runModel(mod, st, size, seed);
		mod.printHashMapInfo();
	}

	private void printOut(String s) {
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for (int k = 0; k < words.length; k++) {
			System.out.print(words[k] + " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}

	public static void main(String[] args) {
		MarkovRunnerWithInterface runner = new MarkovRunnerWithInterface();
		runner.testHashMap();
		//runner.runMarkov();
	}
}