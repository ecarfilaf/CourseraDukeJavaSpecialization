
/**
 * Write a description of ImprovingGladlibs here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/15
 */
import java.util.*;
import edu.duke.*;

public class ImprovingGladlibs {

	private HashMap<String, Integer> dnaHashMap;

	public ImprovingGladlibs() {
		dnaHashMap = new HashMap<String, Integer>();
	}

	public void buildCodonMap(int start, String dna) {
		dnaHashMap.clear();
		int count = 0;
		for (int i = start; i < dna.length() - 2; i += 3) {
			String codon = dna.substring(i, i + 3);
			if (!dnaHashMap.containsKey(codon)) {
				dnaHashMap.put(codon, 1);
				count++;
			} else {
				dnaHashMap.put(codon, dnaHashMap.get(codon) + 1);
			}
		}
		System.out.println("Reading frame starting with " + start +
				", results in " + count + " unique codons");
	}

	public String getMostCommonCodon() {
		int maxValue = 0;
		String bestValue = "";
		for (String s : dnaHashMap.keySet()) {
			if (dnaHashMap.get(s) > maxValue) {
				maxValue = dnaHashMap.get(s);
				bestValue = s;
			}
		}
		return "and most common codon is " + bestValue.toUpperCase() + " with count " + maxValue;
	}

	public void printCodonCounts(int start, int end) {
		System.out.println("Counts of codons between " + start + " and " + end + " inclusive are: \n");
		for (String s : dnaHashMap.keySet()) {
			int HashMap = dnaHashMap.get(s);
			if (HashMap >= start && HashMap <= end) {
				System.out.println(s.toUpperCase() + "\t" + dnaHashMap.get(s));
			}
		}
	}

	public void test() {
		int start = 0;
		String dna = "CAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCTAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCCAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATC";
		dna = dna.toLowerCase();
		buildCodonMap(start, dna);
		System.out.println(getMostCommonCodon());
		printCodonCounts(5, 8);
	}
}
