package ecan;
import edu.duke.*;

public class MarkovRunner {

	public static void runModel(IMarkovModel markov, String text, int size) {
		System.err.println("MarkovRunner.runMarkov.runModel(IMarkovModel,String,size)");
		markov.setTraining(text);
		System.out.println("running with " + markov + ", size = " + size);
		for (int k = 0; k < 3; k++) {
			String st = markov.getRandomText(size);
			printOut(st);
		}
	}

	public static void runModel(IMarkovModel markov, String text, int size, int seed) {
		System.err.println("MarkovRunner.runMarkov.runModel(IMarkovModel,String,size,seed)");
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
		//System.err.println(st);
		MarkovWordOne markovWord = new MarkovWordOne();
		runModel(markovWord, st, 120,139);
	}

	public static void runMarkovTwo() {
		FileResource fr = new FileResource("../data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		//System.err.println(st);
		MarkovWordTwo markovWord = new MarkovWordTwo();
		runModel(markovWord, st, 120,832);
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

	public static void main(String[] args) {
		System.err.println("MarkovRunner main");
		runMarkov();
		runMarkovTwo();
	}
}
