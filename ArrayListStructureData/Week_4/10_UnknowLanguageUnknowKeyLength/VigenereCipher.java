
/**
 * Write a description of VigenereCipher here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/22
 */
import java.util.*;
import edu.duke.*;

public class VigenereCipher {
	CaesarCipher[] ciphers;

	public VigenereCipher(int[] key) {
		ciphers = new CaesarCipher[key.length];
		for (int i = 0; i < key.length; i++) {
			ciphers[i] = new CaesarCipher(key[i]);
		}
	}

	public String encrypt(String input) {
		StringBuilder answer = new StringBuilder();
		int i = 0;
		for (char c : input.toCharArray()) {
			int cipherIndex = i % ciphers.length;
			CaesarCipher thisCipher = ciphers[cipherIndex];
			answer.append(thisCipher.encryptLetter(c));
			i++;
		}
		return answer.toString();
	}

	public String decrypt(String input) {
		StringBuilder answer = new StringBuilder();
		int i = 0;
		for (char c : input.toCharArray()) {
			int cipherIndex = i % ciphers.length;
			CaesarCipher thisCipher = ciphers[cipherIndex];
			answer.append(thisCipher.decryptLetter(c));
			i++;
		}
		return answer.toString();
	}

	public String toString() {
		return Arrays.toString(ciphers);
	}

}
