/**
 * Write a description of CaesarCipher here.
 * 
 * @author Esteban Carfilaf
 * @version 1.001.01 2025/03/12
 */
public class CaesarCipher {

	private String alphabet;
	private String shiftedAlphabet;
	private int mainKey;

	public CaesarCipher(int key) {
		mainKey = key;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
	}

	public String encrypt(String input) {
		StringBuilder sb = new StringBuilder(input);
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			int idx = alphabet.indexOf(c);
			if (idx != -1) {
				c = shiftedAlphabet.charAt(idx);
				sb.setCharAt(i, c);
			}
		}
		return sb.toString();
	}

	public String decrypt(String input) {
		CaesarCipher cc = new CaesarCipher(26 - mainKey);
		String message = cc.encrypt(input);
		return message;
	}
}
