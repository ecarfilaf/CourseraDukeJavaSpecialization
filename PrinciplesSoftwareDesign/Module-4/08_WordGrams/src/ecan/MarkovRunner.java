package ecan;

/**
 * Write a description of interface IMarkovModel here.
 *
 * @author Esteban Carfilaf 
 * @version 1.001.01 2025/04/28
 */

import edu.duke.*;

public class MarkovRunner {

	public void runModel(IMarkovModel markov, String text, int size) {
		markov.setTraining(text);
		System.out.println("running with " + markov);
		for (int k = 0; k < 3; k++) {
			String st = markov.getRandomText(size);
			printOut(st);
		}
	}

	public static void runModel(IMarkovModel markov, String text, int size, int seed) {
		markov.setTraining(text);
		markov.setRandom(seed);
		System.out.println("running with " + markov);
		for (int k = 0; k < 3; k++) {
			String st = markov.getRandomText(size);
			printOut(st);
		}
	}

	public static void runMarkov() {
		FileResource fr = new FileResource("../data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovWord markovWord = new MarkovWord(6);
		runModel(markovWord, st, 200, 792);
	}

	private static void printOut(String s) {
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

	public static void testHashMap() {
		EfficientMarkovWord em = new EfficientMarkovWord(2);
		em.setRandom(42);
		em.setTraining("this is a test yes this is really a test yes a test this is wow");
		em.printHashMapInfo();
	}

	public static void quizHashMap() {
		EfficientMarkovWord em = new EfficientMarkovWord(2);
		FileResource fr = new FileResource("../data/confucius.txt");
		String st = fr.asString();
		//st = st.replace('\n', ' ');
		em.setRandom(65);
		em.setTraining(st);
		em.printHashMapInfo();
	}

	public static void runModelZero(IMarkovModel markov, String text, int size, int seed) {
		markov.setTraining(text);
		markov.setRandom(seed);
		System.out.println("running with " + markov);
		for (int k = 0; k < 3; k++) {
			String st = markov.getRandomText(size);
			printOut(st);
		}
	}

	public static void runMarkovZero() {
		FileResource fr = new FileResource("../data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;
		int seed = 1024;

		MarkovZero marko = new MarkovZero();
		runModelZero(marko, st, size, seed);
	}
	
	public static void main(String[] args) {
		System.err.println("MarkovRunner.main()");
		runMarkov();
		//testHashMap();
		//quizHashMap();
		//runMarkovZero();
	}
}
