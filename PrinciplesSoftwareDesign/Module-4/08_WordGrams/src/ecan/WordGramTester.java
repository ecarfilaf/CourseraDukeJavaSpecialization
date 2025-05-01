package ecan;

/**
 * Write a description of WordGramTester class here.
 *
 * @author Esteban Carfilaf 
 * @version 1.001.01 2025/04/28
 */

import java.util.*;

public class WordGramTester {

	public static void testWordGram(){
		String source = "this is a test this is a test this is a test of words";
		String[] words = source.split("\\s+");
		int size = 4;
		for(int index = 0; index <= words.length - size; index += 1) {
			WordGram wg = new WordGram(words,index,size);
			System.out.println(index+"\t"+wg.length()+"\t"+wg);
		}
	}
	
	public static void testWordGramEquals(){
		String source = "this is a test this is a test this is a test of words";
		String[] words = source.split("\\s+");
		ArrayList<WordGram> list = new ArrayList<WordGram>();
		int size = 4;
		for(int index = 0; index <= words.length - size; index += 1) {
			WordGram wg = new WordGram(words,index,size);
			list.add(wg);
		}
		WordGram first = list.get(0);
		System.out.println("checking "+first);
		for(int k=0; k < list.size(); k++){
			//if (first == list.get(k)) {
			  if (first.equals(list.get(k))) {
				System.out.println("matched at "+k+" "+list.get(k));
			}
		}
	}

	public static void main(String[] args) {
		System.err.println("WordGramTester.main() started");
		testWordGram();
		System.out.println("------------------------------------------------");
		testWordGramEquals();
	}
}
