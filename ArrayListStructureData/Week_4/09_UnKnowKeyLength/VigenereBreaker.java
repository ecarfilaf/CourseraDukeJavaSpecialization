
/**
 * Write a description of VigenereBreaker here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/22
 */
import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
	public String sliceString(String message, int whichSlice, int totalSlices) {
		// // REPLACE WITH YOUR CODE
		// return "WRITE ME!";
		String resp = "";
		int p = whichSlice;

		for (int i = 0; i < message.length(); i++) {
			if (i == p) {
				char c = message.charAt(i);
				resp += c;
				p += totalSlices;
			}
		}

		return resp;
	}

	public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
		int[] key = new int[klength];
		// WRITE YOUR CODE HERE
		CaesarCracker CC = new CaesarCracker(mostCommon);
		for (int i = 0; i < klength; i++) {
			String slice = sliceString(encrypted, i, klength);
			int resKey = CC.getKey(slice);
			// System.out.println("Key: " + resKey);
			key[i] = resKey;
		}
		return key;
	}

	public void breakVigenere() {
		// WRITE YOUR CODE HERE
		FileResource fr = new FileResource("data/secretmessage2.txt");
		String FILE = fr.asString();
		int[] key = tryKeyLength(FILE, 5, 'e');
		VigenereCipher VC = new VigenereCipher(key);
		String decrypt = VC.decrypt(FILE);
		System.out.println("DECRYPTED MESSAGE 5: " + decrypt);
		int[] key2 = tryKeyLength(FILE, 4, 'e');
		VigenereCipher VC2 = new VigenereCipher(key);
		String decrypt2 = VC2.decrypt(FILE);
		System.out.println("DECRYPTED MESSAGE 4: " + decrypt2);
	}

	public String breakVigenere_2() {
		String MaxDecryption = new String();
		// FileResource resource = new
		// FileResource("ViginereMessages/athens_keyflute.txt");
		FileResource resource = new FileResource("data/secretmessage2.txt");
		String message = resource.asString();
		// To read from the English Dictionnary
		HashSet<String> DictContent = new HashSet<String>();
		FileResource dictResource = new FileResource("dictionaries/English.txt");
		DictContent = readDictionary(dictResource);
		MaxDecryption = breakForLanguage(message, DictContent);
		// MaxDecryption = breakForLanguageQuizz(message,DictContent);
		return MaxDecryption;
	}

	public String breakVigenere_3() {
		FileResource fr = new FileResource("data/secretmessage2.txt");
		String FILE = fr.asString();
		int[] key = tryKeyLength(FILE, 38, 'e');
		VigenereCipher VC = new VigenereCipher(key);
		String decrypt = VC.decrypt(FILE);

		HashSet<String> DictContent = new HashSet<String>();
		FileResource dictResource = new FileResource("dictionaries/English.txt");
		DictContent = readDictionary(dictResource);

		int count = countWords(decrypt, DictContent);
		String str = String.valueOf(count);
		return (str);
	}

	public HashSet<String> readDictionary(FileResource fr) {
		HashSet<String> hs = new HashSet<String>();
		for (String line : fr.lines()) {
			hs.add(line.toLowerCase());
		}
		System.out.println(hs);
		return hs;
	}

	public int countWords(String message, HashSet<String> dict) {
		int counts = 0;
		ArrayList<String> MessageInWords = new ArrayList<String>(Arrays.asList(message.split("\\W")));
		for (int i = 0; i < MessageInWords.size(); i++) {
			if (dict.contains(MessageInWords.get(i).toLowerCase())) {
				counts += 1;
			}
		}
		return counts;
	}

	public String breakForLanguage(String encrypted, HashSet<String> dict) {
		int max = 0;
		int keyReturn[] = new int[100];
		int KeyLength = 0;
		String aMessage = new String();
		String largestDecryption = new String();
		String[] decrypted = new String[100];
		for (int klength = 1; klength < 100; klength++) {
			keyReturn = tryKeyLength(encrypted, klength, 'e');
			VigenereCipher VCipher = new VigenereCipher(keyReturn);
			aMessage = VCipher.decrypt(encrypted);
			// counts is a value returned, no use starting from 0
			int counts = countWords(aMessage, dict);
			if (counts > max) {
				max = counts;
				largestDecryption = aMessage;
				KeyLength = klength;
			}
		}
		System.out.println("Max counts:" + max);
		System.out.println("The proper Key Length is :" + KeyLength);
		return largestDecryption;
	}

	public String breakForLanguageQuizz(String encrypted, HashSet<String> dict) {
		int max = 0;
		int keyReturn[] = new int[100];
		String aMessage = new String();
		String largestDecryption = new String();
		String[] decrypted = new String[100];
		keyReturn = tryKeyLength(encrypted, 38, 'e');
		VigenereCipher VCipher = new VigenereCipher(keyReturn);
		aMessage = VCipher.decrypt(encrypted);
		// counts is a value returned, no use starting from 0
		int counts = countWords(aMessage, dict);
		if (counts > max) {
			max = counts;
			largestDecryption = aMessage;
		}
		System.out.println("Max counts:" + max);
		return largestDecryption;
	}

	public String previousbreakVigenere() {
		String MaxDecryption = new String();
		FileResource resource = new FileResource("data/athens_keyflute.txt");
		String message = resource.asString();
		return message;
	}

}
