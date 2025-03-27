import edu.duke.FileResource;

/**
 * Write a description of WordPlay here.
 * 
 * @author Esteban Carfilaf 
 * @version 1.001.01 2025/03/10
 */
public class CaesarCipher {
	public static void main(String[] args) {
		System.out.println(".()");
	}
	public String encrypt(String input, int key){
		StringBuilder encrypted = new StringBuilder(input);
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabet2 = "abcdefghijklmnopqrstuvwxyz";
		String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0, key);
		String shiftedAlphabet2 = alphabet2.substring(key)+alphabet2.substring(0, key);
		for (int i = 0; i < encrypted.length(); i++) {
			char currChar = encrypted.charAt(i);
			int idx = alphabet.indexOf(currChar);
			int idx2 = alphabet2.indexOf(currChar);
			if(idx != -1){
				char newChar = shiftedAlphabet.charAt(idx);
				encrypted.setCharAt(i, newChar);
			}else{
				if(idx2 != -1){
					char newChar = shiftedAlphabet2.charAt(idx2);
					encrypted.setCharAt(i, newChar);
				}
			}
		}
		return encrypted.toString();
	}
	public String encryptTwoKeys(String input, int key, int key2){
		StringBuilder encrypted = new StringBuilder(input);
		String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
		String shiftedAlphabetUpper = alphabetUpper.substring(key)+alphabetUpper.substring(0, key);
		String shiftedAlphabetUpper2 = alphabetUpper.substring(key2)+alphabetUpper.substring(0, key2);
		String shiftedAlphabetLower = alphabetLower.substring(key)+alphabetLower.substring(0, key);
		String shiftedAlphabetLower2 = alphabetLower.substring(key2)+alphabetLower.substring(0, key2);
		for (int i = 0; i < encrypted.length(); i++) {
			if(i % 2 == 0){
				char currChar = encrypted.charAt(i);
				int idx = alphabetUpper.indexOf(currChar);
				int idx2 = alphabetLower.indexOf(currChar);
				if(idx != -1){
					char newChar = shiftedAlphabetUpper.charAt(idx);
					encrypted.setCharAt(i, newChar);
				}else{
					if(idx2 != -1){
						char newChar = shiftedAlphabetLower.charAt(idx2);
						encrypted.setCharAt(i, newChar);
					}
				}
			}else{
				char currChar = encrypted.charAt(i);
				int idx = alphabetUpper.indexOf(currChar);
				int idx2 = alphabetLower.indexOf(currChar);
				if(idx != -1){
					char newChar = shiftedAlphabetUpper2.charAt(idx);
					encrypted.setCharAt(i, newChar);
				}else{
					if(idx2 != -1){
						char newChar = shiftedAlphabetLower2.charAt(idx2);
						encrypted.setCharAt(i, newChar);
					}
				}
			}
		}
		return encrypted.toString();
	}
	public void testCaesar(){
		int key = 17;
		FileResource fr = new FileResource();
		String message = fr.asString();
		String encrypted = encrypt(message, key);
		System.out.println(encrypted);
		String decrypted = encrypt(encrypted, 26-key);
		System.out.println(decrypted);
	}
	public void testEncrypt(){
		System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
		System.out.println(encrypt("First Legion", 23));
		System.out.println(encrypt("First Legion", 17));
		System.out.println(encryptTwoKeys("First Legion", 23,17));
		System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
		System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8,21));
	}
}
