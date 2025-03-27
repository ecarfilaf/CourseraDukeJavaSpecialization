
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
			System.out.println("Key: " + resKey);
			key[i] = resKey;
		}
		return key;
	}

	public void breakVigenere() {
		// WRITE YOUR CODE HERE
		FileResource fr = new FileResource();
		String FILE = fr.asString();
		int[] key = tryKeyLength(FILE, 4, 'e');
		VigenereCipher VC = new VigenereCipher(key);
		String decrypt = VC.decrypt(FILE);
		System.out.println("DECRYPTED MESSAGE: " + decrypt);
	}

}
